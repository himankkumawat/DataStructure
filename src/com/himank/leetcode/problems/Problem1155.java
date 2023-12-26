package com.himank.leetcode.problems;

public class Problem1155 {

    // https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
    public static void main(String[] args) {
        int n = 1, k = 6, target = 3;
        System.out.println("Number of dice rolls with target sum : " + numRollsToTarget(n, k, target));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        final int kMod = 1_000_000_007;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        while (n-- > 0) { // n dices
            int[] newDp = new int[target + 1];
            for (int i = 1; i <= k; ++i)          // numbers 1, 2, ..., f
                for (int t = i; t <= target; ++t) { // all the possible targets
                    newDp[t] += dp[t - i];
                    newDp[t] %= kMod;
                }
            dp = newDp;
        }

        return dp[target];
    }
}
