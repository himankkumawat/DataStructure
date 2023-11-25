package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1685 {

    // https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int[] result = getSumAbsoluteDifferences(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            int rightCount = n - 1 - i;

            int leftTotal = i * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];

            ans[i] = leftTotal + rightTotal;
            leftSum += nums[i];
        }

        return ans;
    }
}
