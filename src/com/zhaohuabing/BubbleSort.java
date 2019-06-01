package com.zhaohuabing;

/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 *
 */
public class BubbleSort {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int swapCount = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapCount++;
                }
            }
        }
        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 7, 8, 6, 1, 0, 2, 3, 4, 5};

        BubbleSort.countSwaps(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
