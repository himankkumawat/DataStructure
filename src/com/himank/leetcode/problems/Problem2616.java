package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2616 {

    // https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 1, 3};
        int p = 2;
        System.out.println("Minimum value of maximize difference pairs : " + minimizeMax(nums, p));
    }

    private static int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (countValidPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
