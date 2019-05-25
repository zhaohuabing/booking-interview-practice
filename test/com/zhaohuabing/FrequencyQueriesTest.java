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

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class FrequencyQueriesTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        List<List<Integer>> queries = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(6);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(3);
        temp.add(2);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(10);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(10);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(6);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(5);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(3);
        temp.add(2);
        queries.add(temp);

        new FrequencyQueries();
        List<Integer> result = FrequencyQueries.freqQuery(queries);
        assertEquals(result.get(0).intValue(), 0);
        assertEquals(result.get(1).intValue(), 1);
    }

}
