package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class MarkAndToysTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        assertEquals(MarkAndToys.maximumToys(new int[] {1, 12, 5, 111, 200, 1000, 10}, 50), 4);
        assertEquals(MarkAndToys.maximumToys(new int[] {1, 2, 3, 4}, 7), 3);
    }

}
