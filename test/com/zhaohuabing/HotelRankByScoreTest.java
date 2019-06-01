package com.zhaohuabing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class HotelRankByScoreTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        String input = "1000 4";
        input += System.lineSeparator();
        input += "1000 7";
        input += System.lineSeparator();
        input += "2000 10";
        input += System.lineSeparator();
        input += "2000 8";
        List<Hotel> result = HotelRankByScore.Sort(input);
        assertEquals(result.get(0).id, 1000);
        assertEquals(result.get(1).id, 2000);

        input = "1000 4";
        input += System.lineSeparator();
        input += "1000 7";
        input += System.lineSeparator();
        input += "2000 10";
        input += System.lineSeparator();
        input += "3000 8";
        input += System.lineSeparator();
        input += "3000 6";
        input += System.lineSeparator();
        input += "2000 8";
        result = HotelRankByScore.Sort(input);
        assertEquals(result.get(0).id, 1000);
        assertEquals(result.get(1).id, 3000);
        assertEquals(result.get(2).id, 2000);
    }

}
