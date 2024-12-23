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

package org.apache.sysds.hops.cost;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.sysds.runtime.DMLRuntimeException;
import org.apache.sysds.runtime.controlprogram.LocalVariableMap;
import org.apache.sysds.runtime.controlprogram.Program;
import org.apache.sysds.runtime.controlprogram.ProgramBlock;
import org.apache.sysds.runtime.controlprogram.context.ExecutionContext;
import org.apache.sysds.utils.stats.Timing;

public class CostEstimationWrapper 
{
	public enum CostType { 
		NUM_MRJOBS, //based on number of MR jobs, [number MR jobs]
		STATIC // based on FLOPS, read/write, etc, [time in sec]
	}
	
	private static final Log LOG = LogFactory.getLog(CostEstimationWrapper.class.getName());
	private static final CostType DEFAULT_COSTTYPE = CostType.STATIC;
	
	private static CostEstimator _costEstim = null;
	
	
	static  {
		//create cost estimator
		try {
			//TODO config parameter?
			_costEstim = createCostEstimator(DEFAULT_COSTTYPE);
		}
		catch(Exception ex) {
			LOG.error("Failed cost estimator initialization.", ex);
		}
	}
	
	public static double getTimeEstimate(Program rtprog, ExecutionContext ec) {
		Timing time = new Timing(true);
		
		HashMap<String,VarStats> stats = new HashMap<>();
		LocalVariableMap vars = (ec!=null)? ec.getVariables() : new LocalVariableMap(); 
		
		double costs = _costEstim.getTimeEstimate(rtprog, vars, stats);
		LOG.debug("Finished estimation in "+time.stop()+"ms.");
		return costs;
	}
	
	public static double getTimeEstimate(ProgramBlock pb, ExecutionContext ec, boolean recursive) {
		Timing time = new Timing(true);
		
		HashMap<String,VarStats> stats = new HashMap<>();
		LocalVariableMap vars = (ec!=null)? ec.getVariables() : new LocalVariableMap(); 
		
		double costs = _costEstim.getTimeEstimate(pb, vars, stats, recursive);
		LOG.debug("Finished estimation in "+time.stop()+"ms.");
		return costs;
	}

	private static CostEstimator createCostEstimator( CostType type ) {
		switch( type )
		{
			case STATIC:
				return new CostEstimatorStaticRuntime();
			default:
				throw new DMLRuntimeException("Unknown cost type: "+type);
		}
	}
}
