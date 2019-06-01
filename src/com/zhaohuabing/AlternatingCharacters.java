
package com.zhaohuabing;

/**
 * https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 *
 */
public class AlternatingCharacters {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();

        int count = 0;
        int i = 0;
        while (i < chars.length - 1) {
            int j = i;
            while (++j < chars.length && chars[j] == chars[i]) {
                count++;
            }
            i = j;
        }
        return count;
    }
}
