package com.himank.dynamic_programming.knapsack;

public class CountOfSubsetWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Total number of subsets possible are : " + getCountOfSubset(arr, sum));
        System.out.println("Total number of subsets possible are : " + getCountOfSubsetRecursive(arr, sum, arr.length));
    }

    public static int getCountOfSubset(int[] arr, int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[arr.length][sum];
    }

    static int[][] dp = new int[6 + 1][10 + 1];             // This is hardcoded for the example taken above.

    static {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
    }

    public static int getCountOfSubsetRecursive(int[] arr, int sum, int n) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (arr[n - 1] <= sum) {
            return dp[n][sum] = getCountOfSubsetRecursive(arr, sum, n - 1) +
                    getCountOfSubsetRecursive(arr, sum - arr[n - 1], n - 1);
        }
        return dp[n][sum] = getCountOfSubsetRecursive(arr, sum, n - 1);
    }
}
