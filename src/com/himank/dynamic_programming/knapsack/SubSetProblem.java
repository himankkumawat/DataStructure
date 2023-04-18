package com.himank.dynamic_programming.knapsack;

public class SubSetProblem {

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int targetSum = 15;
        System.out.println("Target sum is possible via Top down ? : " + isSubSetSumExist(arr, targetSum));
        System.out.println("Target sum is possible via Memoization ? : " + isSubsetSumExistsRecursivelyMemoization(arr, targetSum, arr.length));
        System.out.println("Target sum is possible via Recursive ? : " + isSubsetSumExistsRecursively(arr, targetSum, arr.length));
    }

    public static boolean isSubSetSumExist(int[] arr, int targetSum) {
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][targetSum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < targetSum + 1; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][targetSum];

    }

    static Boolean[][] dp = new Boolean[5 + 1][15 + 1];                         // This is hardcoded for the example taken above.

    static {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
                else dp[i][j] = null;
            }
        }
    }

    public static boolean isSubsetSumExistsRecursivelyMemoization(int[] arr, int targetSum, int n) {
        if (targetSum == 0) return true;
        if (n == 0) return false;
        if (dp[n][targetSum] != null) return dp[n][targetSum];
        if (arr[n - 1] > targetSum)
            return dp[n][targetSum] = isSubsetSumExistsRecursivelyMemoization(arr, targetSum, n - 1);
        return dp[n][targetSum] = isSubsetSumExistsRecursivelyMemoization(arr, targetSum - arr[n - 1], n - 1) ||
                isSubsetSumExistsRecursivelyMemoization(arr, targetSum, n - 1);
    }

    public static boolean isSubsetSumExistsRecursively(int[] arr, int targetSum, int n) {
        if (targetSum == 0) return true;
        if (n == 0) return false;
        if (arr[n - 1] > targetSum)
            return isSubsetSumExistsRecursively(arr, targetSum, n - 1);
        return isSubsetSumExistsRecursively(arr, targetSum - arr[n - 1], n - 1) ||
                isSubsetSumExistsRecursively(arr, targetSum, n - 1);
    }
}
