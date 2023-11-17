package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1877 {

    // https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
    public static void main(String[] args) {
        int[] arr = {3,5,4,2,4,6};
        System.out.println("Minimize maximum pair sum in array: " + minPairSum(arr));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxSum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            maxSum = Math.max(maxSum, nums[i] + nums[nums.length - 1 - i]);
        }

        return maxSum;
    }
}
