package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

public class Problem1793 {

    // https://leetcode.com/problems/maximum-score-of-a-good-subarray/
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 7, 4, 5};
        int k = 3;
        System.out.println("Maximum score of good subarray: " + maximumScore(nums, k));
    }

    public static int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] right = new int[n];
        Arrays.fill(right, n);
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] < k && right[i] > k) {
                ans = Math.max(ans, nums[i] * (right[i] - left[i] - 1));
            }
        }
        return ans;
    }
}
