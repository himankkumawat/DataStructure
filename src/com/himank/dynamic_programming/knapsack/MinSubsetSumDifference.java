package com.himank.dynamic_programming.knapsack;

import java.util.Arrays;

public class MinSubsetSumDifference {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};

        System.out.println("Minimum difference of subset is : " + minSubsetDiff(arr));
    }

    public static int minSubsetDiff(int[] arr) {
        int rangeSum = 0;
        for (int ele : arr) {
            rangeSum += ele;
        }

        /*      Let say rangeSum = sum of all elements
                && sum of subset1 = s1, sum of subset2 = s2
                Now, s1 + s2 = rangeSum;
                So, s2 = rangeSum - s1

                As per question, s2 - s1 should be minimum.
                So, rangeSum - s1 - s1 should be minimum.
                So, rangeSum - 2(s1) should be minimum.
                rangeSum is constant for any given set of array.

        */
        boolean[] rangeSumPossible = getRangeSumPossible(arr, rangeSum);

        int minDiff = rangeSum;

        for (int i = 0; i < rangeSumPossible.length; i++) {
            if (rangeSumPossible[i]) {
                minDiff = Math.min(minDiff, Math.abs(rangeSum - 2 * i));
            }
        }
        return minDiff;
    }

    public static boolean[] getRangeSumPossible(int[] arr, int targetSum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        Arrays.fill(dp[0], true);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n];
    }
}
