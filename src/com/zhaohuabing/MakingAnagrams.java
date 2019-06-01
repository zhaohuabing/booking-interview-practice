package com.zhaohuabing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 *
 */
public class MakingAnagrams {

    /**
     * A much simpler solution: use two int array to store the frequency of the char
     */
    static int makeAnagram(String a, String b) {
        int[] frequencyA = countFrequency(a);
        int[] frequencyB = countFrequency(b);

        int count = 0;

        for (int i = 0; i < frequencyA.length; i++) {
            count += Math.abs(frequencyA[i] - frequencyB[i]);
        }
        return count;
    }

    static int[] countFrequency(String s) {
        int[] frequency = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            frequency[charArray[i] - 97] += 1;
        }
        return frequency;
    }

    /**
     * This solution use HashMap to store the frequency of chars.
     */
    static int makeAnagram1(String a, String b) {
        int count = 0;
        Map<Character, Integer> mapA = initMap(a);
        Map<Character, Integer> mapB = initMap(b);

        Iterator<Character> it = mapA.keySet().iterator();
        while (it.hasNext()) {
            char c = it.next();
            int frequencyA = mapA.get(c);
            if (mapB.containsKey(c)) {
                int frequencyB = mapB.get(c);
                count += Math.abs(frequencyA - frequencyB);
                int min = Math.min(frequencyA, frequencyB);
                mapA.put(c, min);
                mapB.put(c, min);
            } else {
                count += frequencyA;
            }
        }

        it = mapB.keySet().iterator();
        while (it.hasNext()) {
            char c = it.next();
            int frequencyB = mapB.get(c);
            if (mapA.containsKey(c)) {
                int frequencyA = mapA.get(c);
                count += Math.abs(frequencyA - frequencyB);
                int min = Math.min(frequencyA, frequencyB);
                mapA.put(c, min);
                mapB.put(c, min);
            } else {
                count += frequencyB;
            }
        }
        return count;
    }

    static Map<Character, Integer> initMap(String s) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
            int frequency = 0;
            if (charMap.containsKey(charArray[i])) {
                frequency = charMap.get(charArray[i]);
            }
            frequency++;
            charMap.put(charArray[i], frequency);
        }
        return charMap;
    }
}
