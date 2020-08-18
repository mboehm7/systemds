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

package org.apache.sysds.runtime.instructions.fed;

import org.apache.sysds.runtime.controlprogram.caching.MatrixObject;
import org.apache.sysds.runtime.controlprogram.context.ExecutionContext;
import org.apache.sysds.runtime.controlprogram.federated.FederatedRequest;
import org.apache.sysds.runtime.controlprogram.federated.FederationUtils;
import org.apache.sysds.runtime.instructions.cp.CPOperand;
import org.apache.sysds.runtime.matrix.operators.Operator;

public class BinaryMatrixScalarFEDInstruction extends BinaryFEDInstruction
{
	protected BinaryMatrixScalarFEDInstruction(Operator op,
		CPOperand in1, CPOperand in2, CPOperand out, String opcode, String istr) {
		super(FEDType.Binary, op, in1, in2, out, opcode, istr);
	}

	@Override
	public void processInstruction(ExecutionContext ec) {
		CPOperand matrix = input1.isMatrix() ? input1 : input2;
		CPOperand scalar = input2.isScalar() ? input2 : input1;
		MatrixObject mo = ec.getMatrixObject(matrix);
		
		//execute federated matrix-scalar operation and cleanups
		FederatedRequest fr1 = !scalar.isLiteral() ?
			mo.getFedMapping().broadcast(ec.getScalarInput(scalar)) : null;
		FederatedRequest fr2 = FederationUtils.callInstruction(instString, output,
			new CPOperand[]{matrix, (fr1 != null)?scalar:null},
			new long[]{mo.getFedMapping().getID(), (fr1 != null)?fr1.getID():-1});
		
		mo.getFedMapping().execute(getTID(), true, (fr1!=null) ?
			new FederatedRequest[]{fr1, fr2}: new FederatedRequest[]{fr2});
		if( fr1 != null )
			mo.getFedMapping().cleanup(getTID(), fr1.getID());
		
		//derive new fed mapping for output
		MatrixObject out = ec.getMatrixObject(output);
		out.getDataCharacteristics().set(mo.getDataCharacteristics());
		out.setFedMapping(mo.getFedMapping().copyWithNewID(fr2.getID()));
	}
}
