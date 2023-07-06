package com.himank.leetcode.problems;

public class Problem209 {

    // https://leetcode.com/problems/minimum-size-subarray-sum/description/
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("Minimum size subarray sum : " + minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right, sumOfCurrentWindow = 0;
        int res = Integer.MAX_VALUE;

        for (right = 0; right < nums.length; right++) {
            sumOfCurrentWindow += nums[right];

            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left + 1);
                sumOfCurrentWindow -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
