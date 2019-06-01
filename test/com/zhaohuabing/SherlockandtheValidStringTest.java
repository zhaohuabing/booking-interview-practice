
package com.zhaohuabing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Huabing Zhao
 *
 */
public class SherlockandtheValidStringTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        assertEquals(SherlockandtheValidString.isValid("aabbcd"), "NO");
        assertEquals(SherlockandtheValidString.isValid("aabbccddeefghi"), "NO");
        assertEquals(SherlockandtheValidString.isValid("a"), "YES");
        assertEquals(SherlockandtheValidString.isValid("aabbc"), "YES");
    }

}
