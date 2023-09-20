package com.himank.leetcode.problems;

public class Problem1658 {

    // https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println("Minimum number of operation is: " + minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int current = 0;
        for (int num : nums) {
            current += num;
        }
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            current -= nums[right];
            while (current < x && left <= right) {
                current += nums[left];
                left += 1;
            }
            if (current == x) {
                mini = Math.min(mini, (n - 1 - right) + left);
            }
        }
        return mini != Integer.MAX_VALUE ? mini : -1;
    }
}
