package com.zhaohuabing;

/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 *
 */
public class MarkAndToys {
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int pieces = 0;
        int totalPrice = 0;
        //sort descending and find the max pieces from the cheapest price
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (prices[j] < prices[j + 1]) {
                    int tmp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = tmp;
                }
            }
            if (totalPrice + prices[i] < k) {
                totalPrice += prices[i];
                pieces++;
            } else {
                return pieces;
            }
        }
        return pieces;
    }

    public static void main(String[] args) {
        System.out.println(MarkAndToys.maximumToys(new int[] {1, 12, 5, 111, 200, 1000, 10}, 50));
    }
}
