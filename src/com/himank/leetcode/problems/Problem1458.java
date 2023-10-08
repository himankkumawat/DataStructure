package com.himank.leetcode.problems;

public class Problem1458 {

    // https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/
    public static void main(String[] args) {
        int[] nums1 = {2, 1, -2, 5}, nums2 = {3, 0, -6};
        System.out.println("Maximum dot product of 2 subsequence : " + maxDotProduct(nums1, nums2));
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }

        for (int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }

        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax;
        }

        int m = nums2.length + 1;
        int[] dp = new int[m];
        int[] prevDp = new int[m];

        for (int i = nums1.length - 1; i >= 0; i--) {
            dp = new int[m];
            for (int j = nums2.length - 1; j >= 0; j--) {
                int use = nums1[i] * nums2[j] + prevDp[j + 1];
                dp[j] = Math.max(use, Math.max(prevDp[j], dp[j + 1]));
            }

            prevDp = dp;
        }

        return dp[0];
    }
}
