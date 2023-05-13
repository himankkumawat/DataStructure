package com.himank.leetcode.problems;

public class Problem2499 {

    // https://leetcode.com/problems/count-ways-to-build-good-strings/
    public static void main(String[] args) {
        int low = 3;
        int high = 3;
        int zero = 1;
        int one = 1;
        System.out.println("Number of ways to make a good String is : " + countGoodStrings(low, high, zero, one));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int mod = 1_000_000_007;

        for (int end = 1; end <= high; ++end) {
            if (end >= zero) {
                dp[end] += dp[end - zero];
            }
            if (end >= one) {
                dp[end] += dp[end - one];
            }
            dp[end] %= mod;
        }

        int answer = 0;
        for (int i = low; i <= high; ++i) {
            answer += dp[i];
            answer %= mod;
        }
        return answer;
    }
}
