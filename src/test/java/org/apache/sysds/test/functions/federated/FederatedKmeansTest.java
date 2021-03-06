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

package org.apache.sysds.test.functions.federated;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.apache.sysds.common.Types;
import org.apache.sysds.common.Types.ExecMode;
import org.apache.sysds.runtime.meta.MatrixCharacteristics;
import org.apache.sysds.runtime.util.HDFSTool;
import org.apache.sysds.test.AutomatedTestBase;
import org.apache.sysds.test.TestConfiguration;
import org.apache.sysds.test.TestUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
@net.jcip.annotations.NotThreadSafe
public class FederatedKmeansTest extends AutomatedTestBase {

	private final static String TEST_DIR = "functions/federated/";
	private final static String TEST_NAME = "FederatedKmeansTest";
	private final static String TEST_CLASS_DIR = TEST_DIR + FederatedKmeansTest.class.getSimpleName() + "/";

	private final static int blocksize = 1024;
	@Parameterized.Parameter()
	public int rows;
	@Parameterized.Parameter(1)
	public int cols;
	@Parameterized.Parameter(2)
	public int runs;

	@Override
	public void setUp() {
		TestUtils.clearAssertionInformation();
		addTestConfiguration(TEST_NAME, new TestConfiguration(TEST_CLASS_DIR, TEST_NAME, new String[] {"Z"}));
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		// rows have to be even and > 1
		return Arrays.asList(new Object[][] {
			{10000, 10, 1}, {2000, 50, 1}, {1000, 100, 1},
			//TODO support for multi-threaded federated interactions
			//{10000, 10, 16}, {2000, 50, 16}, {1000, 100, 16}, //concurrent requests
		});
	}

	@Test
	public void federatedKmeansSinglenode() {
		federatedKmeans(Types.ExecMode.SINGLE_NODE);
	}
	
	@Test
	public void federatedKmeansHybrid() {
		federatedKmeans(Types.ExecMode.HYBRID);
	}

	public void federatedKmeans(Types.ExecMode execMode) {
		ExecMode platformOld = setExecMode(execMode);

		getAndLoadTestConfiguration(TEST_NAME);
		String HOME = SCRIPT_DIR + TEST_DIR;

		// write input matrices
		int halfRows = rows / 2;
		// We have two matrices handled by a single federated worker
		double[][] X1 = getRandomMatrix(halfRows, cols, 0, 1, 1, 3);
		double[][] X2 = getRandomMatrix(halfRows, cols, 0, 1, 1, 7);
		writeInputMatrixWithMTD("X1", X1, false, new MatrixCharacteristics(halfRows, cols, blocksize, halfRows * cols));
		writeInputMatrixWithMTD("X2", X2, false, new MatrixCharacteristics(halfRows, cols, blocksize, halfRows * cols));

		// empty script name because we don't execute any script, just start the worker
		fullDMLScriptName = "";
		int port1 = getRandomAvailablePort();
		int port2 = getRandomAvailablePort();
		Thread t1 = startLocalFedWorker(port1);
		Thread t2 = startLocalFedWorker(port2);

		TestConfiguration config = availableTestConfigurations.get(TEST_NAME);
		loadTestConfiguration(config);
		setOutputBuffering(false);
		
		// Run reference dml script with normal matrix
		fullDMLScriptName = HOME + TEST_NAME + "Reference.dml";
		programArgs = new String[] {"-args", input("X1"), input("X2"),
			String.valueOf(runs), expected("Z")};
		runTest(true, false, null, -1);

		// Run actual dml script with federated matrix
		fullDMLScriptName = HOME + TEST_NAME + ".dml";
		programArgs = new String[] {"-stats",
			"-nvargs", "in_X1=" + TestUtils.federatedAddress(port1, input("X1")),
			"in_X2=" + TestUtils.federatedAddress(port2, input("X2")), "rows=" + rows, "cols=" + cols,
			"runs=" + String.valueOf(runs), "out=" + output("Z")};
		runTest(true, false, null, -1);

		// compare via files
		//compareResults(1e-9); --> randomized
		TestUtils.shutdownThreads(t1, t2);
		
		// check for federated operations
		Assert.assertTrue(heavyHittersContainsString("fed_ba+*"));
		Assert.assertTrue(heavyHittersContainsString("fed_uasqk+"));
		Assert.assertTrue(heavyHittersContainsString("fed_uarmin"));
		Assert.assertTrue(heavyHittersContainsString("fed_*"));
		Assert.assertTrue(heavyHittersContainsString("fed_+"));
		Assert.assertTrue(heavyHittersContainsString("fed_<="));
		Assert.assertTrue(heavyHittersContainsString("fed_/"));
		
		//check that federated input files are still existing
		Assert.assertTrue(HDFSTool.existsFileOnHDFS(input("X1")));
		Assert.assertTrue(HDFSTool.existsFileOnHDFS(input("X2")));
		
		resetExecMode(platformOld);
	}
}
