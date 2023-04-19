package com.himank.dynamic_programming.knapsack;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};

        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        // if sum --> odd, then answer is always false.

        System.out.println("Equal Sum Partition is possible via top down? :" + (sum % 2 == 0 &&
                isSubSetSumExist(arr, sum / 2)));

        System.out.println("Equal Sum Partition is possible via Memoization? :" + (sum % 2 == 0 &&
                isSubsetSumExistsRecursivelyMemoization(arr, sum/2, arr.length)));

        System.out.println("Equal Sum Partition is possible via recursively? :" + (sum % 2 == 0 &&
                isSubsetSumExistsRecursively(arr, sum/2, arr.length)));
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
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][targetSum];
    }

    static Boolean[][] dp = new Boolean[4 + 1][11 + 1];                         // This is hardcoded for the example taken above. 11 = sum / 2

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
