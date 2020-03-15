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

package org.tugraz.sysds.test.functions.federated;


import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.tugraz.sysds.api.DMLScript;
import org.tugraz.sysds.common.Types;
import org.tugraz.sysds.test.AutomatedTestBase;
import org.tugraz.sysds.test.TestConfiguration;
import org.tugraz.sysds.test.TestUtils;

import java.util.Arrays;

import static java.lang.Thread.sleep;


@RunWith(Parameterized.class)
public class FederatedMatrixScalarOperationsTest extends AutomatedTestBase
{
	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ 100, 100 },
			{ 10000, 100 },
		 });
	}

	//internals 4 parameterized tests
	@Parameterized.Parameter(0)
	public Integer rows;
	@Parameterized.Parameter(1)
	public Integer cols;

	//System test paths
	private static final String TEST_DIR = "functions/federated/matrix_scalar/";
	private static final String TEST_CLASS_DIR = TEST_DIR + FederatedMatrixScalarOperationsTest.class.getSimpleName() + "/";
	private static final String TEST_PROG_MATRIX_ADDITION_SCALAR = "FederatedMatrixAdditionScalar";
	private static final String TEST_PROG_MATRIX_SUBTRACTION_SCALAR = "FederatedMatrixSubtractionScalar";
	private static final String TEST_PROG_MATRIX_MULTIPLICATION_SCALAR = "FederatedMatrixMultiplicationScalar";
	private static final String TEST_PROG_SCALAR_ADDITION_MATRIX = "ScalarAdditionFederatedMatrix";
	private static final String TEST_PROG_SCALAR_SUBTRACTION_MATRIX = "ScalarSubtractionFederatedMatrix";
	private static final String TEST_PROG_SCALAR_MULTIPLICATION_MATRIX = "ScalarMultiplicationFederatedMatrix";

	private static final String FEDERATED_WORKER_HOST = "localhost";
	private static final int FEDERATED_WORKER_PORT = 1222;

	@Override
	public void setUp() 
	{
		//Save Result to File R
		addTestConfiguration(new TestConfiguration(TEST_CLASS_DIR, TEST_PROG_MATRIX_ADDITION_SCALAR, new String [] {"R"}));
		addTestConfiguration(new TestConfiguration(TEST_CLASS_DIR, TEST_PROG_MATRIX_SUBTRACTION_SCALAR, new String [] {"R"}));
		addTestConfiguration(new TestConfiguration(TEST_CLASS_DIR, TEST_PROG_MATRIX_MULTIPLICATION_SCALAR, new String [] {"R"}));
		addTestConfiguration(new TestConfiguration(TEST_CLASS_DIR, TEST_PROG_SCALAR_ADDITION_MATRIX, new String [] {"R"}));
		addTestConfiguration(new TestConfiguration(TEST_CLASS_DIR, TEST_PROG_SCALAR_SUBTRACTION_MATRIX, new String [] {"R"}));
		addTestConfiguration(new TestConfiguration(TEST_CLASS_DIR, TEST_PROG_SCALAR_MULTIPLICATION_MATRIX, new String [] {"R"}));
	}
    
    @Test
	public void testFederatedMatrixAdditionScalar() {
		getAndLoadTestConfiguration(TEST_PROG_MATRIX_ADDITION_SCALAR);

		double[][] m = getRandomMatrix(this.rows, this.cols, -1, 1, 1.0, 1);
		writeInputMatrixWithMTD("M", m, true);
		int s = TestUtils.getRandomInt();
		double[][] r = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				r[i][j] = m[i][j] + s;
			}
		}
		writeExpectedMatrix("R", r);

		runGenericTest(TEST_PROG_MATRIX_ADDITION_SCALAR, s);
	}

	@Test
	public void testFederatedMatrixSubtractionScalar() {
		getAndLoadTestConfiguration(TEST_PROG_MATRIX_SUBTRACTION_SCALAR);

		double[][] m = getRandomMatrix(this.rows, this.cols, -1, 1, 1.0, 1);
		writeInputMatrixWithMTD("M", m, true);
		int s = TestUtils.getRandomInt();
		double[][] r = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				r[i][j] = m[i][j] - s;
			}
		}
		writeExpectedMatrix("R", r);

		runGenericTest(TEST_PROG_MATRIX_SUBTRACTION_SCALAR, s);
	}

	@Test
	public void testFederatedMatrixMultiplicationScalar() {
		getAndLoadTestConfiguration(TEST_PROG_MATRIX_MULTIPLICATION_SCALAR);

		double[][] m = getRandomMatrix(this.rows, this.cols, -1, 1, 1.0, 1);
		writeInputMatrixWithMTD("M", m, true);
		int s = TestUtils.getRandomInt();
		double[][] r = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				r[i][j] = m[i][j] * s;
			}
		}
		writeExpectedMatrix("R", r);

		runGenericTest(TEST_PROG_MATRIX_MULTIPLICATION_SCALAR, s);
	}

	@Test
	public void testScalarAdditionFederatedMatrix() {
		getAndLoadTestConfiguration(TEST_PROG_SCALAR_ADDITION_MATRIX);

		double[][] m = getRandomMatrix(this.rows, this.cols, -1, 1, 1.0, 1);
		writeInputMatrixWithMTD("M", m, true);
		int s = TestUtils.getRandomInt();
		double[][] r = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				r[i][j] = m[i][j] + s;
			}
		}
		writeExpectedMatrix("R", r);

		runGenericTest(TEST_PROG_SCALAR_ADDITION_MATRIX, s);
	}

	@Test
	public void testScalarSubtractionFederatedMatrix() {
		getAndLoadTestConfiguration(TEST_PROG_SCALAR_SUBTRACTION_MATRIX);

		double[][] m = getRandomMatrix(this.rows, this.cols, -1, 1, 1.0, 1);
		writeInputMatrixWithMTD("M", m, true);
		int s = TestUtils.getRandomInt();
		double[][] r = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				r[i][j] = s - m[i][j];
			}
		}
		writeExpectedMatrix("R", r);

		runGenericTest(TEST_PROG_SCALAR_SUBTRACTION_MATRIX, s);
	}

	@Test
	public void testScalarMultiplicationFederatedMatrix() {
		getAndLoadTestConfiguration(TEST_PROG_SCALAR_MULTIPLICATION_MATRIX);

		double[][] m = getRandomMatrix(this.rows, this.cols, -1, 1, 1.0, 1);
		writeInputMatrixWithMTD("M", m, true);
		int s = TestUtils.getRandomInt();
		double[][] r = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				r[i][j] = m[i][j] * s;
			}
		}
		writeExpectedMatrix("R", r);

		runGenericTest(TEST_PROG_SCALAR_MULTIPLICATION_MATRIX, s);
	}




	private void runGenericTest(String dmlFile, int s)
	{
		boolean sparkConfigOld = DMLScript.USE_LOCAL_SPARK_CONFIG;
		Types.ExecMode platformOld = rtplatform;

		Thread t = null;
		try {
			// we need the reference file to not be written to hdfs, so we get the correct format
			rtplatform = Types.ExecMode.SINGLE_NODE;
			if (rtplatform == Types.ExecMode.SPARK) {
				DMLScript.USE_LOCAL_SPARK_CONFIG = true;
			}
			programArgs = new String[] {"-w", Integer.toString(FEDERATED_WORKER_PORT)};
			t = new Thread(() -> runTest(true, false, null, -1));
			t.start();
			sleep(FED_WORKER_WAIT);
			fullDMLScriptName = SCRIPT_DIR + TEST_DIR + dmlFile + ".dml";
			programArgs = new String[]{"-args",
					TestUtils.federatedAddress(FEDERATED_WORKER_HOST, FEDERATED_WORKER_PORT, input("M")),
					Integer.toString(rows), Integer.toString(cols),
					Integer.toString(s),
					output("R")};
			runTest(true, false, null, -1);

			compareResults();
		} catch (InterruptedException e) {
			e.printStackTrace();
			assert (false);
		} finally {
			rtplatform = platformOld;
			TestUtils.shutdownThread(t);
			rtplatform = platformOld;
			DMLScript.USE_LOCAL_SPARK_CONFIG = sparkConfigOld;
		}
	}
}
