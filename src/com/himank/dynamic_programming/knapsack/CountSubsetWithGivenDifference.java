package com.himank.dynamic_programming.knapsack;

public class CountSubsetWithGivenDifference {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        System.out.println("Number of subset with given difference : " + getSubsetCountForDiff(arr, diff));
    }

    public static int getSubsetCountForDiff(int[] arr, int diff) {
        int totalSum = 0;
        for (int ele : arr) {
            totalSum += ele;
        }

        /*

        s1 - s2 = 1
        s1 + s2 = 7;
        So, 2(s1) = 8;
        So, s1 = 4;
        hence we need to find a subset which can be made for sum = 4;
         */

        int targetSum = (totalSum + diff) / 2;
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
