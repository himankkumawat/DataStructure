package com.himank.dynamic_programming.knapsack;

public class TargetSum {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};                   // Place either + or - sign before each element in arr so that the 2 subset sum is 1.
        int sum = 1;

        System.out.println("Total subsets combinations are : " + getTargetSumCount(arr, sum));
    }

    public static int getTargetSumCount(int[] arr, int sum) {
        int totalSum = 0;
        for (int ele : arr) {
            totalSum += ele;

        }

        /*
        few elements will be positive and few will be negative.
        So, s1 - s2 = 1
        Also, s1 + s2 = 7;
        So, 2(s1) = 8;
        So, s1 = 4;
        If we can find out a no of subset which results in 4, we can get s1 - s2 = 1;
         */

        int targetSum = (totalSum + sum) / 2;
        return getSubsetSum(arr, targetSum, arr.length);
    }

    static int[][] dp = new int[4 + 1][4 + 1];             // This is hardcoded for the example taken above.

    static {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
    }

    public static int getSubsetSum(int[] arr, int targetSum, int n) {
        if (targetSum == 0) return 1;
        if (n == 0) return 0;

        if (arr[n - 1] > targetSum) {
            return dp[n - 1][targetSum] = getSubsetSum(arr, targetSum, n - 1);
        } else {
            return dp[n - 1][targetSum] = getSubsetSum(arr, targetSum - arr[n - 1], n - 1) +
                    getSubsetSum(arr, targetSum, n - 1);
        }
    }
}
