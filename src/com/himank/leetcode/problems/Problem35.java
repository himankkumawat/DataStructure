package com.himank.leetcode.problems;

public class Problem35 {

    // https://leetcode.com/problems/search-insert-position/description/
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("inserting position is : " + searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return left;
    }
}
