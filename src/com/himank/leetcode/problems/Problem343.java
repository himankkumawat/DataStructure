package com.himank.leetcode.problems;

public class Problem343 {

    // https://leetcode.com/problems/integer-break/description/
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Maximum product of integer break: " + integerBreak(n));
    }

    public static int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) {
            dp[i] = i;
        }

        for (int num = 4; num <= n; num++) {
            int ans = num;
            for (int i = 2; i < num; i++) {
                ans = Math.max(ans, i * dp[num - i]);
            }
            dp[num] = ans;
        }
        return dp[n];
    }
}
