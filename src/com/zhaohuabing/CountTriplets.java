/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * You are given an array and you need to find number of tripets of indices such that the elements
 * at those indices are in geometric progression for a given common ratio and .
 * 
 * For example, . If , we have and at indices and .
 * 
 * Function Description
 * 
 * Complete the countTriplets function in the editor below. It should return the number of triplets
 * forming a geometric progression for a given as an integer.
 * 
 * countTriplets has the following parameter(s):
 * 
 * arr: an array of integers r: an integer, the common ratio Input Format
 * 
 * The first line contains two space-separated integers and , the size of and the common ratio. The
 * next line contains space-seperated integers .
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Return the count of triplets that form a geometric progression.
 * 
 * Sample Input 0
 * 
 * 4 2 1 2 2 4 Sample Output 0
 * 
 * 2 Explanation 0
 * 
 * There are triplets in satisfying our criteria, whose indices are and
 * 
 * Sample Input 1
 * 
 * 6 3 1 3 9 9 27 81 Sample Output 1
 * 
 * 6 Explanation 1
 * 
 * The triplets satisfying are index , , , , and .
 * 
 * Sample Input 2
 * 
 * 5 5 1 5 5 25 125 Sample Output 2
 * 
 * 4 Explanation 2
 * 
 * The triplets satisfying are index , , , .
 */
package com.zhaohuabing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long ratio) {
        Map<Long, Integer> rightMap = new HashMap<Long, Integer>();
        Map<Long, Integer> leftMap = new HashMap<Long, Integer>();

        //init the maps
        for (int i = 2; i < arr.size(); i++) {
            int count = 0;
            if (rightMap.get(arr.get(i)) != null) {
                count = rightMap.get(arr.get(i));
            }

            rightMap.put(arr.get(i), ++count);
        }

        leftMap.put(arr.get(0), 1);

        long count = 0;
        for (int i = 1; i < arr.size() - 1; i++) {
            long second = arr.get(i);
            if (second % ratio == 0) {
                long first = second / ratio;
                long third = second * ratio;

                int contFirst = 0;
                if (leftMap.containsKey(first)) {
                    contFirst = leftMap.get(first);
                }
                int countThird = 0;
                if (rightMap.containsKey(third)) {
                    countThird = rightMap.get(third);
                }
                count += contFirst * countThird;

                //increase the count of num in left map
                long leftNum = second;
                if (leftMap.get(leftNum) != null) {
                    leftMap.put(leftNum, leftMap.get(leftNum) + 1);
                } else {
                    leftMap.put(leftNum, 1);
                }

                //decrease the count of num in right map
                long rightNum = arr.get(i + 1);
                rightMap.put(rightNum, rightMap.get(rightNum) - 1);
            }

        }
        return count;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Long> input = new ArrayList<Long>();
        input.add((long) 2);
        input.add((long) 2);
        input.add((long) 2);
        input.add((long) 2);
        input.add((long) 2);
        input.add((long) 2);
        input.add((long) 2);
        System.out.println(CountTriplets.countTriplets(input, 1));

        input = new ArrayList<Long>();
        input.add((long) 1);
        input.add((long) 3);
        input.add((long) 27);
        input.add((long) 9);
        input.add((long) 27);
        input.add((long) 81);
        System.out.println(CountTriplets.countTriplets(input, 3));

        input = new ArrayList<Long>();
        input.add((long) 1);
        input.add((long) 1);
        input.add((long) 1);
        input.add((long) 1);
        input.add((long) 1);
        System.out.println(CountTriplets.countTriplets(input, 1));
    }

}
