package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class ConnectedCellInGridTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        int[][] grid = new int[][] {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        assertEquals(ConnectedCellInGrid.maxRegion(grid), 5);
    }

}
