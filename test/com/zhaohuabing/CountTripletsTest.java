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
public class CountTripletsTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        List<Long> input = new ArrayList<Long>();
        input.add((long) 1);
        input.add((long) 2);
        input.add((long) 2);
        input.add((long) 4);
        assertEquals(CountTriplets.countTriplets(input, 2), 2);

        input = new ArrayList<Long>();
        input.add((long) 1);
        input.add((long) 3);
        input.add((long) 9);
        input.add((long) 9);
        input.add((long) 27);
        input.add((long) 81);
        assertEquals(CountTriplets.countTriplets(input, 3), 6);

        input = new ArrayList<Long>();
        input.add((long) 1);
        input.add((long) 1);
        input.add((long) 1);
        input.add((long) 1);
        input.add((long) 1);
        assertEquals(CountTriplets.countTriplets(input, 1), 10);
    }

}
