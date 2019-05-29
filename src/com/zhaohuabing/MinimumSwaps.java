package com.zhaohuabing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. 
 * You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 */
public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        //key: number in array, value: index of number
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                swap(arr, indexMap, i);
                count++;
            }
        }
        return count;
    }

    /**
     * @param arr
     * @param indexMap
     * @param i
     */
    private static void swap(int[] arr, Map<Integer, Integer> indexMap, int i) {
        int index = indexMap.get(i + 1);
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
        indexMap.put(arr[i], i + 1);
        indexMap.put(temp, index);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(MinimumSwaps.minimumSwaps(new int[] {1, 3, 6, 4, 5, 9, 7, 8, 2}));
    }
}
