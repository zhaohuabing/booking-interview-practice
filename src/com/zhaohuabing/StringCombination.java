package com.zhaohuabing;

import java.util.Arrays;

/**
 * Given a string of lowercase unique characters (e.g. "ab", "lmne") sort the string alphabetically
 * and then find all possible combinations, ignoring ordering. e.g. "ab" -> "a", "b", "ab"
 *
 */
public class StringCombination {
    public static void test(String input) {
        char[] chars = new char[input.length()];
        input.getChars(0, input.length(), chars, 0);
        Arrays.sort(chars);

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        System.out.println("**************");
        for (int i = 1; i <= chars.length; i++) {
            getCombination("", chars, i, 0);
        }
    }

    public static void getCombination(String prefix, char[] availableChars, int pos, int next) {
        if (pos == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = next; i < availableChars.length; i++) {
            String newprefix = prefix + availableChars[i];
            getCombination(newprefix, availableChars, pos - 1, i + 1);
        }
    }

    public static void main(String[] args) {
        StringCombination.test("bcadef");
    }
}
