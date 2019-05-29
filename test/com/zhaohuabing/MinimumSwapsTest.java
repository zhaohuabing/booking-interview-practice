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
public class MinimumSwapsTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        assertEquals(MinimumSwaps.minimumSwaps(new int[] {1, 3, 6, 4, 5, 9, 7, 8, 2}), 3);
        assertEquals(MinimumSwaps.minimumSwaps(new int[] {1, 2, 3}), 0);
        assertEquals(MinimumSwaps.minimumSwaps(new int[] {4, 3, 2, 1}), 2);
    }

}
