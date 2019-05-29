/**
 * Copyright 2017 ZTE Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class ArrayManipulationTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        int n = 10;
        int[][] queries = new int[3][3];
        queries[0] = new int[] {1, 5, 3};
        queries[1] = new int[] {4, 8, 7};
        queries[2] = new int[] {6, 9, 1};
        assertEquals(ArrayManipulation.arrayManipulation(n, queries), 10);
    }

}