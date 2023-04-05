package com.himank.leetcode.problems;

public class Problem2439 {

    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 6};
        System.out.println("minimum value of max array value : " + minimizeArrayValue(nums));
    }

    public static int minimizeArrayValue(int[] nums) {
        long answer = 0, prefixSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i) / (i + 1));
        }

        return (int)answer;
    }
}
