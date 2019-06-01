package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class MergeSortTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        int[] result = MergeSort.mergeSort(new int[] {3, 2, 1, 4});
        assertArrayEquals(result, new int[] {1, 2, 3, 4});
        result = MergeSort.mergeSort(new int[] {0, 5, 3, 2, 1, 4});
        assertArrayEquals(result, new int[] {0, 1, 2, 3, 4, 5});
    }

}
