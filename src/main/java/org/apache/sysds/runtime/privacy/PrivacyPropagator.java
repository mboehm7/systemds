/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sysds.runtime.privacy;

import org.apache.sysds.parser.DataExpression;
import org.apache.sysds.runtime.DMLRuntimeException;
import org.apache.sysds.runtime.controlprogram.context.ExecutionContext;
import org.apache.sysds.runtime.instructions.Instruction;
import org.apache.sysds.runtime.instructions.cp.BinaryCPInstruction;
import org.apache.sysds.runtime.instructions.cp.BuiltinNaryCPInstruction;
import org.apache.sysds.runtime.instructions.cp.CPInstruction;
import org.apache.sysds.runtime.instructions.cp.CPOperand;
import org.apache.sysds.runtime.instructions.cp.ComputationCPInstruction;
import org.apache.sysds.runtime.instructions.cp.Data;
import org.apache.sysds.runtime.instructions.cp.FunctionCallCPInstruction;
import org.apache.sysds.runtime.instructions.cp.MultiReturnParameterizedBuiltinCPInstruction;
import org.apache.sysds.runtime.instructions.cp.ParameterizedBuiltinCPInstruction;
import org.apache.sysds.runtime.instructions.cp.MultiReturnBuiltinCPInstruction;
import org.apache.sysds.runtime.instructions.cp.QuaternaryCPInstruction;
import org.apache.sysds.runtime.instructions.cp.SqlCPInstruction;
import org.apache.sysds.runtime.instructions.cp.UnaryCPInstruction;
import org.apache.sysds.runtime.instructions.cp.VariableCPInstruction;
import org.apache.sysds.runtime.privacy.PrivacyConstraint.PrivacyLevel;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

/**
 * Class with static methods merging privacy constraints of operands 
 * in expressions to generate the privacy constraints of the output. 
 */
public class PrivacyPropagator
{
	public static Data parseAndSetPrivacyConstraint(Data cd, JSONObject mtd)
		throws JSONException
	{
		if ( mtd.containsKey(DataExpression.PRIVACY) ) {
			String privacyLevel = mtd.getString(DataExpression.PRIVACY);
			if ( privacyLevel != null )
				cd.setPrivacyConstraints(new PrivacyConstraint(PrivacyLevel.valueOf(privacyLevel)));
		}
		return cd;
	}
	
	public static PrivacyConstraint mergeBinary(PrivacyConstraint privacyConstraint1, PrivacyConstraint privacyConstraint2) {
		if (privacyConstraint1 != null && privacyConstraint2 != null){
			PrivacyLevel privacyLevel1 = privacyConstraint1.getPrivacyLevel();
			PrivacyLevel privacyLevel2 = privacyConstraint2.getPrivacyLevel();

			// One of the inputs are private, hence the output must be private.
			if (privacyLevel1 == PrivacyLevel.Private || privacyLevel2 == PrivacyLevel.Private)
				return new PrivacyConstraint(PrivacyLevel.Private);
			// One of the inputs are private with aggregation allowed, but none of the inputs are completely private,
			// hence the output must be private with aggregation.
			else if (privacyLevel1 == PrivacyLevel.PrivateAggregation || privacyLevel2 == PrivacyLevel.PrivateAggregation)
				return new PrivacyConstraint(PrivacyLevel.PrivateAggregation);
			// Both inputs have privacy level "None", hence the privacy constraint can be removed.
			else  
				return null;
		}
		else if (privacyConstraint1 != null)
			return privacyConstraint1;
		else if (privacyConstraint2 != null)
			return privacyConstraint2; 
		return null;
	}

	public static PrivacyConstraint mergeNary(PrivacyConstraint[] privacyConstraints){
		PrivacyConstraint mergedPrivacyConstraint = privacyConstraints[0];
		for ( int i = 1; i < privacyConstraints.length; i++ ){
			mergedPrivacyConstraint = mergeBinary(mergedPrivacyConstraint, privacyConstraints[i]);
		}
		return mergedPrivacyConstraint;
	}

	public static Instruction preprocessInstruction(Instruction inst, ExecutionContext ec){
		switch ( inst.getType() ){
			case CONTROL_PROGRAM:
				return preprocessCPInstruction( (CPInstruction) inst, ec );
			case BREAKPOINT:
			case SPARK:
			case GPU:
			case FEDERATED:
				return inst;
			default:
				throwExceptionIfPrivacyActivated(inst, ec);
				return inst;
		}
	}

	public static Instruction preprocessCPInstruction(CPInstruction inst, ExecutionContext ec){
		switch ( inst.getCPInstructionType() )
		{
			case Variable:
				return preprocessVariableCPInstruction((VariableCPInstruction) inst, ec);
			case AggregateUnary:
			case Reorg:
			case Unary:
				return preprocessUnaryCPInstruction((UnaryCPInstruction) inst, ec);
			case AggregateBinary:
			case Append: 
			case Binary:
				return preprocessBinaryCPInstruction((BinaryCPInstruction) inst, ec);
			case AggregateTernary: 
			case Ternary:
				return preprocessTernaryCPInstruction((ComputationCPInstruction) inst, ec);
			case Quaternary: 
				return preprocessQuaternary((QuaternaryCPInstruction) inst, ec);
			case BuiltinNary:
			case Builtin:
				return preprocessBuiltinNary((BuiltinNaryCPInstruction) inst, ec);
			case FCall:
				return preprocessExternal((FunctionCallCPInstruction) inst, ec);
			case MultiReturnBuiltin:
			case MultiReturnParameterizedBuiltin:
				return preprocessMultiReturn((ComputationCPInstruction)inst, ec);
			case ParameterizedBuiltin:
				return preprocessParameterizedBuiltin((ParameterizedBuiltinCPInstruction) inst, ec);
			case Ctable:   
			default:
				return preprocessInstructionSimple(inst, ec);
		}
	}

	/**
	 * Throw exception if privacy constraints are activated or return instruction if privacy is not activated
	 * @param inst instruction
	 * @param ec execution context
	 * @return instruction
	 */
	public static Instruction preprocessInstructionSimple(Instruction inst, ExecutionContext ec){
		throwExceptionIfPrivacyActivated(inst, ec);
		return inst;
	}


	public static Instruction preprocessExternal(FunctionCallCPInstruction inst, ExecutionContext ec){
		return mergePrivacyConstraintsFromInput(
			inst, 
			ec, 
			inst.getInputs(), 
			inst.getBoundOutputParamNames().toArray(new String[0])
		);
	}

	public static Instruction preprocessMultiReturn(ComputationCPInstruction inst, ExecutionContext ec){
		if ( inst instanceof MultiReturnBuiltinCPInstruction )
			return mergePrivacyConstraintsFromInput(inst, ec, inst.getInputs(), ((MultiReturnBuiltinCPInstruction) inst).getOutputNames() );
		else if ( inst instanceof MultiReturnParameterizedBuiltinCPInstruction )
			return mergePrivacyConstraintsFromInput(inst, ec, inst.getInputs(), ((MultiReturnParameterizedBuiltinCPInstruction) inst).getOutputNames() );
		else throw new DMLRuntimeException("ComputationCPInstruction not recognized as either MultiReturnBuiltinCPInstruction or MultiReturnParameterizedBuiltinCPInstruction");
	}

	public static Instruction preprocessParameterizedBuiltin(ParameterizedBuiltinCPInstruction inst, ExecutionContext ec){
		return mergePrivacyConstraintsFromInput(inst, ec, inst.getInputs(), new String[]{inst.getOutputVariableName()} );
	}

	private static Instruction mergePrivacyConstraintsFromInput(Instruction inst, ExecutionContext ec, CPOperand[] inputs, String[] outputNames){
		if ( inputs != null && inputs.length > 0 ){
			PrivacyConstraint[] privacyConstraints = getInputPrivacyConstraints(ec, inputs);
			if ( privacyConstraints != null ){
				PrivacyConstraint mergedPrivacyConstraint = mergeNary(privacyConstraints);
				inst.setPrivacyConstraint(mergedPrivacyConstraint);
				if ( outputNames != null ){
					for (String outputName : outputNames)
						setOutputPrivacyConstraint(ec, mergedPrivacyConstraint, outputName);
				}
			}
		}
		return inst;
	}

	private static Instruction mergePrivacyConstraintsFromInput(Instruction inst, ExecutionContext ec, CPOperand[] inputs, CPOperand output){
		String outputName = (output != null) ? output.getName() : null;
		return mergePrivacyConstraintsFromInput(inst, ec, inputs, new String[]{outputName});	
	}

	public static Instruction preprocessBuiltinNary(BuiltinNaryCPInstruction inst, ExecutionContext ec){
		return mergePrivacyConstraintsFromInput(inst, ec, inst.getInputs(), inst.getOutput() );
	}

	public static Instruction preprocessQuaternary(QuaternaryCPInstruction inst, ExecutionContext ec){
		return mergePrivacyConstraintsFromInput(
			inst, 
			ec, 
			new CPOperand[] {inst.input1,inst.input2,inst.input3,inst.getInput4()},
			inst.output
		);
	}

	public static Instruction preprocessTernaryCPInstruction(ComputationCPInstruction inst, ExecutionContext ec){
		return mergePrivacyConstraintsFromInput(inst, ec, inst.getInputs(), inst.output);
	}

	public static Instruction preprocessBinaryCPInstruction(BinaryCPInstruction inst, ExecutionContext ec){
		PrivacyConstraint privacyConstraint1 = getInputPrivacyConstraint(ec, inst.input1);
		PrivacyConstraint privacyConstraint2 = getInputPrivacyConstraint(ec, inst.input2);
		if ( privacyConstraint1 != null || privacyConstraint2 != null) {
			PrivacyConstraint mergedPrivacyConstraint = mergeBinary(privacyConstraint1, privacyConstraint2);
			inst.setPrivacyConstraint(mergedPrivacyConstraint);
			setOutputPrivacyConstraint(ec, mergedPrivacyConstraint, inst.output);
		}
		return inst;
	}

	public static Instruction preprocessUnaryCPInstruction(UnaryCPInstruction inst, ExecutionContext ec){
		return propagateInputPrivacy(inst, ec, inst.input1, inst.output);
	}

	public static Instruction preprocessVariableCPInstruction(VariableCPInstruction inst, ExecutionContext ec){
		switch ( inst.getVariableOpcode() ) {
			case CreateVariable:
				return propagateSecondInputPrivacy(inst, ec);
			case AssignVariable:
				//Assigns scalar, hence it does not have privacy activated
				return inst;
			case CopyVariable:
			case MoveVariable:
				return propagateFirstInputPrivacy(inst, ec);
			case RemoveVariable:
				return propagateAllInputPrivacy(inst, ec);
			case RemoveVariableAndFile:
				return propagateFirstInputPrivacy(inst, ec);
			case CastAsScalarVariable: 
				return propagateCastAsScalarVariablePrivacy(inst, ec);
			case CastAsMatrixVariable:
			case CastAsFrameVariable:
				return propagateFirstInputPrivacy(inst, ec);
			case CastAsDoubleVariable:
			case CastAsIntegerVariable:
			case CastAsBooleanVariable:
				return propagateCastAsScalarVariablePrivacy(inst, ec);
			case Read:
				return inst;
			case Write:
				return propagateFirstInputPrivacy(inst, ec);
			case SetFileName:
				return propagateFirstInputPrivacy(inst, ec);
			default:
				throwExceptionIfPrivacyActivated(inst, ec);
				return inst;
		}
	}

	private static void throwExceptionIfPrivacyActivated(Instruction inst, ExecutionContext ec){
		if ( inst.getPrivacyConstraint() != null && inst.getPrivacyConstraint().getPrivacyLevel() == PrivacyLevel.Private ) {
			throw new DMLPrivacyException("Instruction " + inst + " has privacy constraints activated, but the constraints are not propagated during preprocessing of instruction.");
		}
	}

	/**
	 * Propagate privacy from first input.
	 * @param inst Instruction
	 * @param ec execution context
	 * @return instruction with or without privacy constraints
	 */
	private static Instruction propagateCastAsScalarVariablePrivacy(VariableCPInstruction inst, ExecutionContext ec){
		inst = (VariableCPInstruction) propagateFirstInputPrivacy(inst, ec); 
		return inst;
	}

	/**
	 * Propagate privacy constraints from all inputs if privacy constraints are set.
	 * @param inst instruction
	 * @param ec execution context
	 * @return instruction with or without privacy constraints
	 */
	private static Instruction propagateAllInputPrivacy(VariableCPInstruction inst, ExecutionContext ec){
		return mergePrivacyConstraintsFromInput(
			inst, ec, inst.getInputs().toArray(new CPOperand[0]), inst.getOutput());
	}

	/**
	 * Propagate privacy constraint to instruction and output of instruction
	 * if data of first input is CacheableData and 
	 * privacy constraint is activated.
	 * @param inst VariableCPInstruction
	 * @param ec execution context
	 * @return instruction with or without privacy constraints
	 */
	private static Instruction propagateFirstInputPrivacy(VariableCPInstruction inst, ExecutionContext ec){
		return propagateInputPrivacy(inst, ec, inst.getInput1(), inst.getOutput());
	}

	/**
	 * Propagate privacy constraint to instruction and output of instruction
	 * if data of second input is CacheableData and 
	 * privacy constraint is activated.
	 * @param inst VariableCPInstruction
	 * @param ec execution context
	 * @return instruction with or without privacy constraints
	 */
	private static Instruction propagateSecondInputPrivacy(VariableCPInstruction inst, ExecutionContext ec){
		return propagateInputPrivacy(inst, ec, inst.getInput2(), inst.getOutput());
	}

	/**
	 * Propagate privacy constraint to instruction and output of instruction
	 * if data of the specified variable is CacheableData 
	 * and privacy constraint is activated
	 * @param inst instruction
	 * @param ec execution context
	 * @param inputOperand input from which the privacy constraint is found
	 * @param outputOperand output which the privacy constraint is propagated to
	 * @return instruction with or without privacy constraints
	 */
	private static Instruction propagateInputPrivacy(Instruction inst, ExecutionContext ec, CPOperand inputOperand, CPOperand outputOperand){
		PrivacyConstraint privacyConstraint = getInputPrivacyConstraint(ec, inputOperand);
		if ( privacyConstraint != null ) {
			inst.setPrivacyConstraint(privacyConstraint);
			if ( outputOperand != null)
				setOutputPrivacyConstraint(ec, privacyConstraint, outputOperand);
		}
		return inst;
	}

	/**
	 * Get privacy constraint of input data variable from execution context.
	 * @param ec execution context from which the data variable is retrieved
	 * @param input data variable from which the privacy constraint is retrieved
	 * @return privacy constraint of variable or null if privacy constraint is not set
	 */
	private static PrivacyConstraint getInputPrivacyConstraint(ExecutionContext ec, CPOperand input){
		if ( input != null && input.getName() != null){
			Data dd = ec.getVariable(input.getName());
			if ( dd != null )
				return dd.getPrivacyConstraint();
		}
		return null;
	}


	private static PrivacyConstraint[] getInputPrivacyConstraints(ExecutionContext ec, CPOperand[] inputs){
		if ( inputs != null && inputs.length > 0){
			boolean privacyFound = false;
			PrivacyConstraint[] privacyConstraints = new PrivacyConstraint[inputs.length];
			for ( int i = 0; i < inputs.length; i++ ){
				privacyConstraints[i] = getInputPrivacyConstraint(ec, inputs[i]);
				if ( privacyConstraints[i] != null )
					privacyFound = true;
			}
			if ( privacyFound )
				return privacyConstraints;
		}
		return null;
	}

	private static void setOutputPrivacyConstraint(ExecutionContext ec, PrivacyConstraint privacyConstraint, CPOperand output){
		setOutputPrivacyConstraint(ec, privacyConstraint, output.getName());
	}

	/**
	 * Set privacy constraint of data variable with outputName 
	 * if the variable exists and the privacy constraint is not null.
	 * @param ec execution context from which the data variable is retrieved
	 * @param privacyConstraint privacy constraint which the variable should have
	 * @param outputName name of variable that is retrieved from the execution context
	 */
	private static void setOutputPrivacyConstraint(ExecutionContext ec, PrivacyConstraint privacyConstraint, String outputName){
		if ( privacyConstraint != null ){
			Data dd = ec.getVariable(outputName);
			if ( dd != null ){
				dd.setPrivacyConstraints(privacyConstraint);
				ec.setVariable(outputName, dd);
			}
		}
	}

	public static void postProcessInstruction(Instruction inst, ExecutionContext ec){
		PrivacyConstraint instructionPrivacyConstraint = inst.getPrivacyConstraint();
		if ( privacyConstraintActivated(instructionPrivacyConstraint) )
		{
			String[] instructionOutputNames = getOutputVariableName(inst);
			if ( instructionOutputNames != null && instructionOutputNames.length > 0 )
				for ( String instructionOutputName : instructionOutputNames )
					setOutputPrivacyConstraint(ec, instructionPrivacyConstraint, instructionOutputName);
		}
	}

	private static boolean privacyConstraintActivated(PrivacyConstraint instructionPrivacyConstraint){
		return instructionPrivacyConstraint != null && 
			(instructionPrivacyConstraint.privacyLevel == PrivacyLevel.Private 
			|| instructionPrivacyConstraint.privacyLevel == PrivacyLevel.PrivateAggregation);
	}

	private static String[] getOutputVariableName(Instruction inst){
		String[] instructionOutputNames = null;
		// The order of the following statements is important
		if ( inst instanceof MultiReturnParameterizedBuiltinCPInstruction )
			instructionOutputNames = ((MultiReturnParameterizedBuiltinCPInstruction) inst).getOutputNames();
		else if ( inst instanceof MultiReturnBuiltinCPInstruction )
			instructionOutputNames = ((MultiReturnBuiltinCPInstruction) inst).getOutputNames();
		else if ( inst instanceof ComputationCPInstruction )
			instructionOutputNames = new String[]{((ComputationCPInstruction) inst).getOutputVariableName()};
		else if ( inst instanceof VariableCPInstruction )
			instructionOutputNames = new String[]{((VariableCPInstruction) inst).getOutputVariableName()};
		else if ( inst instanceof SqlCPInstruction )
			instructionOutputNames = new String[]{((SqlCPInstruction) inst).getOutputVariableName()};
		return instructionOutputNames;
	}
}
