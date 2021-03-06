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
