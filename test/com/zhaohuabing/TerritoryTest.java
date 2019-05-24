package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class TerritoryTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test1() {
        /**
         * B B B B 
         * W B W B 
         * B W W B 
         * B B B B
         */
        char[][] input = new char[4][4];
        input[0] = new char[] {'B', 'B', 'B', 'B'};
        input[1] = new char[] {'W', 'B', 'W', 'B'};
        input[2] = new char[] {'B', 'W', 'W', 'B'};
        input[3] = new char[] {'B', 'B', 'B', 'B'};
        assertEquals(new Territory().findEnclosedEntity(input), 3);
    }

    @Test
    public void test2() {
        /**
         * B B B B B
         * W B W W W
         * W W B W B
         * B W B W W
         * B B W B B
         * B B B B B
         */
        char[][] input = new char[6][5];
        input[0] = new char[] {'B', 'B', 'B', 'B', 'B'};
        input[1] = new char[] {'W', 'B', 'W', 'W', 'W'};
        input[2] = new char[] {'W', 'W', 'B', 'W', 'B'};
        input[3] = new char[] {'B', 'W', 'B', 'W', 'W'};
        input[4] = new char[] {'B', 'B', 'W', 'B', 'B'};
        input[5] = new char[] {'B', 'B', 'B', 'B', 'B'};
        assertEquals(new Territory().findEnclosedEntity(input), 1);
    }

    @Test
    public void test3() {
        /**
         * B B B B B
         * W B W B W
         * W W B W B
         * B W B W W
         * B B W B B
         * B B B B B
         */
        char[][] input = new char[6][5];
        input[0] = new char[] {'B', 'B', 'B', 'B', 'B'};
        input[1] = new char[] {'W', 'B', 'W', 'B', 'W'};
        input[2] = new char[] {'W', 'W', 'B', 'W', 'B'};
        input[3] = new char[] {'B', 'W', 'B', 'W', 'W'};
        input[4] = new char[] {'B', 'B', 'W', 'B', 'B'};
        input[5] = new char[] {'B', 'B', 'B', 'B', 'B'};
        assertEquals(new Territory().findEnclosedEntity(input), 2);
    }

}
