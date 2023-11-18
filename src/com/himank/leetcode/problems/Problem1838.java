package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1838 {

    // https://leetcode.com/problems/frequency-of-the-most-frequent-element/
    public static void main(String[] args) {
        int[] nums = {1, 4, 8, 13};
        int k = 5;
        System.out.println("Frequency of the Most Frequent Element " + maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long curr = 0;

        for (int right = 0; right < nums.length; right++) {
            int target = nums[right];
            curr += target;

            if ((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }
        }

        return nums.length - left;
    }
}
