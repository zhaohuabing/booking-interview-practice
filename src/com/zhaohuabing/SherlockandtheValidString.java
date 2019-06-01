package com.zhaohuabing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen
 *
 */
public class SherlockandtheValidString {
    // Complete the isValid function below.
    static String isValid(String s) {

        //Count the occurs of chars in the string
        int[] frequency = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            frequency[chars[i] - 97]++;
        }

        //Count the count of the same frequency
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                int k = 0;
                if (count.containsKey(frequency[i])) {
                    k = count.get(frequency[i]);
                }
                count.put(frequency[i], ++k);
            }
            if (count.size() > 2) {
                return "NO";
            }
        }

        if (count.size() == 1) {
            return "YES";
        }

        Iterator<Integer> it = count.keySet().iterator();
        int frequency1 = it.next();
        int count1 = count.get(frequency1);
        int frequency2 = it.next();
        int count2 = count.get(frequency2);
        if (count1 > count2 && frequency2 - frequency1 == 1) {
            return "YES";
        }
        if (count2 > count1 && frequency1 - frequency2 == 1) {
            return "YES";
        }
        //edge case: both the count and frequency ==1
        if ((count1 == 1 && frequency1 == 1) || (count2 == 1 && frequency2 == 1)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(SherlockandtheValidString.isValid("aabbc"));
    }
}
