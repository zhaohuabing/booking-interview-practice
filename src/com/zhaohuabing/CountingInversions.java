package com.zhaohuabing;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 *
 */
public class CountingInversions {
    static long reversion = 0;

    static long count(int[] arr) {
        reversion = 0;
        int[] result = mergeSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        return reversion;
    }

    static int[] mergeSort(int[] arr) {
        int half = arr.length / 2;
        if (half > 0) {
            int[] left = new int[half];
            int[] right = new int[arr.length - half];
            for (int i = 0; i < half; i++) {
                left[i] = arr[i];
            }
            for (int i = half; i < arr.length; i++) {
                right[i - half] = arr[i];
            }
            left = mergeSort(left);
            right = mergeSort(right);
            return merge(left, right);
        }
        return arr;
    }

    //Merge two sorted array
    static int[] merge(int[] arr1, int arr2[]) {
        int[] result = new int[arr1.length + arr2.length];

        int index = 0;
        for (int i = 0; i < arr1.length;) {
            for (int j = 0; j < arr2.length;) {
                if (arr1[i] <= arr2[j]) {
                    result[index++] = arr1[i];
                    i++;
                } else {
                    reversion = reversion + arr1.length - i;
                    result[index++] = arr2[j];
                    j++;
                }
                if (i == arr1.length) {
                    for (int k = j; k < arr2.length; k++) {
                        result[i + k] = arr2[k];
                    }
                    return result;
                }
                if (j == arr2.length) {
                    for (int k = i; k < arr1.length; k++) {
                        result[j + k] = arr1[k];
                    }
                    return result;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {7, 5, 3, 1};

        long result = CountingInversions.count(arr);
        System.out.print("reversion :" + result);

    }
}
