package com.himank.leetcode.problems;

public class Problem896 {

    // https://leetcode.com/problems/monotonic-array/
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.println("Is Array monotonic? : " + isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i+1])
                increasing = false;
            if (nums[i] < nums[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}
