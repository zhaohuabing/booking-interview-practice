
package com.zhaohuabing;

/**
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 */
public class ArrayManipulation {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        long[] result = new long[n];

        //Time complexity is O(m+n)
        //通过-num来判断一个query的结束
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int num = queries[i][2];

            arr[start - 1] += num;
            arr[end] -= num;
        }

        //通过累加来将多重循环简化为一次循环
        result[0] = arr[0];
        long max = result[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + arr[i];
            if (result[i] > max) {
                max = result[i];
            }
        }
        return max;
    }

    static long arrayManipulationSimple(int n, int[][] queries) {
        long[] arr = new long[n];

        //Time complexity is O(m*n)
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int num = queries[i][2];

            for (int j = start - 1; j < end; j++) {
                arr[j] += num;
            }
        }

        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int n = 10;
        int[][] queries = new int[3][3];
        queries[0] = new int[] {1, 5, 3};
        queries[1] = new int[] {4, 8, 7};
        queries[2] = new int[] {6, 9, 1};

        long result = arrayManipulation(n, queries);

        System.out.println(result);
    }
}
