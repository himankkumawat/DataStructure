package com.himank.leetcode.problems;

public class Problem1269 {

    // https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
    public static void main(String[] args) {
        int steps = 3, arrLen = 2;
        System.out.println("Number of ways to stay in same place after some steps : " + numWays(steps, arrLen));
    }

    public static int numWays(int steps, int arrLen) {
        int MOD = (int) 1e9 + 7;
        arrLen = Math.min(arrLen, steps);
        int[] dp = new int[arrLen];
        int[] prevDp = new int[arrLen];
        prevDp[0] = 1;

        for (int remain = 1; remain <= steps; remain++) {
            dp = new int[arrLen];
            for (int curr = arrLen - 1; curr >= 0; curr--) {
                int ans = prevDp[curr];
                if (curr > 0) {
                    ans = (ans + prevDp[curr - 1]) % MOD;
                }
                if (curr < arrLen - 1) {
                    ans = (ans + prevDp[curr + 1]) % MOD;
                }
                dp[curr] = ans;
            }
            prevDp = dp;
        }
        return dp[0];
    }
}
