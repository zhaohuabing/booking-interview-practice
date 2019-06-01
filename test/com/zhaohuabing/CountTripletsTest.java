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
