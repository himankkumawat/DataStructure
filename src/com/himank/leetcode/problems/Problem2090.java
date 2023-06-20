package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2090 {

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int[] result = getAverages(nums, 3);
        System.out.println("Average array : " + Arrays.toString(result));
    }

    public static int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        if (2 * k + 1 > n) {
            return averages;
        }
        long windowSum = 0;
        for (int i = 0; i < (2 * k + 1); ++i) {
            windowSum += nums[i];
        }
        averages[k] = (int) (windowSum / (2 * k + 1));

        for (int i = (2 * k + 1); i < n; ++i) {
            windowSum = windowSum - nums[i - (2 * k + 1)] + nums[i];
            averages[i - k] = (int) (windowSum / (2 * k + 1));
        }

        return averages;
    }
}
