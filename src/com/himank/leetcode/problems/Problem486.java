package com.himank.leetcode.problems;

public class Problem486 {

    // https://leetcode.com/problems/predict-the-winner/
    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println("Player 1 wins? " + predictTheWinner(nums));
    }

    private static int maxDiff(int[] nums, int left, int right, int n) {
        if (left == right) {
            return nums[left];
        }

        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
        int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);

        return Math.max(scoreByLeft, scoreByRight);
    }

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return maxDiff(nums, 0, n - 1, n) >= 0;
    }
}
