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
public class IntervalsTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void testInterval() {
        Interval i1 = new Interval(1, 4);
        Interval i2 = new Interval(2, 5);
        assertTrue(i1.isOverlapped(i2));

        i1 = new Interval(2, 5);
        i2 = new Interval(1, 4);
        assertTrue(i1.isOverlapped(i2));

        i1 = new Interval(2, 5);
        i2 = new Interval(1, 7);
        assertTrue(i1.isOverlapped(i2));

        i1 = new Interval(1, 4);
        i2 = new Interval(6, 7);
        assertFalse(i1.isOverlapped(i2));

        i1 = new Interval(10, 11);
        i2 = new Interval(3, 5);
        assertFalse(i1.isOverlapped(i2));
    }

    @Test
    public void testMerge() {
        Interval[] result = Intervals.merge(new Interval[] {new Interval(6, 9), new Interval(10, 15),
                        new Interval(1, 2), new Interval(2, 3)});
        assertEquals(result.length, 3);
        assertEquals(result[0], new Interval(1, 3));
        assertEquals(result[1], new Interval(6, 9));
        assertEquals(result[2], new Interval(10, 15));

        result = Intervals.merge(new Interval[] {new Interval(6, 9), new Interval(10, 15), new Interval(1, 2),
                        new Interval(2, 3), new Interval(1, 2), new Interval(4, 7), new Interval(11, 20)});
        assertEquals(result.length, 3);
        assertEquals(result[0], new Interval(1, 3));
        assertEquals(result[1], new Interval(4, 9));
        assertEquals(result[2], new Interval(10, 20));
    }

}
