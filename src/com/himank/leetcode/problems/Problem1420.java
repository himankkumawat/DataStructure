package com.himank.leetcode.problems;

public class Problem1420 {

    // https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/
    public static void main(String[] args) {
        int n = 2, m = 3, k = 1;
        System.out.println("Number of ways to build an array : " + numOfArrays(n, m, k));
    }

    public static int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        long[][][] prefix = new long[n + 1][m + 1][k + 1];
        int MOD = (int) 1e9 + 7;

        for (int num = 1; num <= m; num++) {
            dp[1][num][1] = 1;
            prefix[1][num][1] = prefix[1][num - 1][1] + 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int maxNum = 1; maxNum <= m; maxNum++) {
                for (int cost = 1; cost <= k; cost++) {
                    long ans = (maxNum * dp[i - 1][maxNum][cost]) % MOD;
                    ans = (ans + prefix[i - 1][maxNum - 1][cost - 1]) % MOD;

                    dp[i][maxNum][cost] += ans;
                    dp[i][maxNum][cost] %= MOD;

                    prefix[i][maxNum][cost] = (prefix[i][maxNum - 1][cost] + dp[i][maxNum][cost]);
                    prefix[i][maxNum][cost] %= MOD;
                }
            }
        }

        return (int) prefix[n][m][k];
    }
}
