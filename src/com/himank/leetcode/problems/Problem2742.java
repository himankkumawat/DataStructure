package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2742 {

    // https://leetcode.com/problems/painting-the-walls/
    public static void main(String[] args) {
        int[] cost = {2, 3, 4, 2}, time = {1, 1, 1, 1};
        System.out.println("Minimum amount of money required to paint the wall : " + paintWalls(cost, time));
    }

    public static int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        int[] prevDp = new int[n + 1];
        Arrays.fill(prevDp, (int) 1e9);
        prevDp[0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp = new int[n + 1];
            for (int remain = 1; remain <= n; remain++) {
                int paint = cost[i] + prevDp[Math.max(0, remain - 1 - time[i])];
                int dontPaint = prevDp[remain];
                dp[remain] = Math.min(paint, dontPaint);
            }

            prevDp = dp;
        }

        return dp[n];
    }
}
