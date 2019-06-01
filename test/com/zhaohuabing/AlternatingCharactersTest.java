package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class AlternatingCharactersTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        assertEquals(AlternatingCharacters.alternatingCharacters("AAAA"), 3);
        assertEquals(AlternatingCharacters.alternatingCharacters("BBBBB"), 4);
        assertEquals(AlternatingCharacters.alternatingCharacters("BABABA"), 0);
        assertEquals(AlternatingCharacters.alternatingCharacters("AAABBB"), 4);
    }

}
