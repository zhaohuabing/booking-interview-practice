package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
