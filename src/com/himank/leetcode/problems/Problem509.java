package com.himank.leetcode.problems;

public class Problem509 {

    // https://leetcode.com/problems/fibonacci-number/
    public static void main(String[] args) {
        System.out.println("10th fibonacci number is : " + fib(10));
    }

    public static int fib(int n) {
        if (n < 2)
            return n;

        int[] dp = {0, 0, 1};

        for (int i = 2; i <= n; ++i) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1];
        }

        return dp[2];
    }
}
