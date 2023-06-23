package com.himank.leetcode.problems;

import java.util.HashMap;

public class Problem1027 {

    // https://leetcode.com/problems/longest-arithmetic-subsequence/description/
    public static void main(String[] args) {
        int[] nums = {20, 1, 15, 3, 10, 5, 8};
        System.out.println("Longest arithmetic subsequence : " + longestArithSeqLength(nums));
    }

    public static int longestArithSeqLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int right = 0; right < nums.length; ++right) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; ++left) {
                int diff = nums[left] - nums[right];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                maxLength = Math.max(maxLength, dp[right].get(diff));
            }
        }
        return maxLength;
    }
}
