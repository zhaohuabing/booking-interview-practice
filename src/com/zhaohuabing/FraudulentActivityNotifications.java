package com.zhaohuabing;

/**https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting@author Huabing Zhao
 *
 */
public class FraudulentActivityNotifications {
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;
        sortFirstNDay(expenditure, d);
        for (int i = d; i < expenditure.length; i++) {
            double median = findMedian(expenditure, i - d, i - 1);
            if (expenditure[i] >= median * 2) {
                result++;
            }
        }
        System.out.println(result);
        return result;
    }

    static void sortFirstNDay(int[] expenditure, int n) {
        //Use bubble sort to sort the first n day
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (expenditure[j] > expenditure[j + 1]) {
                    int tmp = expenditure[j];
                    expenditure[j] = expenditure[j + 1];
                    expenditure[j + 1] = tmp;
                }
            }
        }
    }


    static double findMedian(int[] expenditure, int start, int end) {
        //put the last one in the right position
        for (int i = start; i < end; i++) {
            if (expenditure[end] < expenditure[i]) {
                int tmp = expenditure[end];
                for (int j = end; j > i; j--) {
                    expenditure[j] = expenditure[j - 1];
                }
                expenditure[i] = tmp;
                break;
            }
        }
        double median = 0;
        if ((end - start + 1) % 2 == 1) {
            median = expenditure[start + (end - start) / 2];
        } else {
            median = ((double) expenditure[start + (end - start) / 2]
                            + (double) expenditure[start + (end - start) / 2 + 1]) / 2;
        }

        return median;
    }

    public static void main(String[] args) {

        FraudulentActivityNotifications.activityNotifications(new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5}, 5);
    }
}
