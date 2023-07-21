package com.himank.leetcode.problems;

public class Problem673 {

    // https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println("Number of longest subsequence : " + findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        int maxLength = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            calculateDP(i, nums, length, count);
            maxLength = Math.max(maxLength, length[i]);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }

        return result;
    }

    private static void calculateDP(int i, int[] nums, int[] length, int[] count) {
        if (length[i] != 0) {
            return;
        }

        length[i] = 1;
        count[i] = 1;

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                calculateDP(j, nums, length, count);
                if (length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    count[i] = 0;
                }
                if (length[j] + 1 == length[i]) {
                    count[i] += count[j];
                }
            }
        }
    }
}
