package com.himank.leetcode.problems;

public class Problem2348 {

    // https://leetcode.com/problems/number-of-zero-filled-subarrays/
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println("Total combination is : " + zeroFilledSubarrayNew(nums1));
        System.out.println("Total combination is : " + zeroFilledSubarray(nums1));
    }

    public static long zeroFilledSubarrayNew(int[] nums) {
        long totalCombination = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                j = i + 1;
            }
            totalCombination += i - j + 1;
        }
        return totalCombination;
    }

    public static long zeroFilledSubarray(int[] nums) {
        long totalCombination = 0;
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                start = i;
                while (i < nums.length && nums[i] == 0) {
                    i++;
                }
                end = i;
                totalCombination += getCombination(end - start);
            }
        }
        return totalCombination;
    }

    private static long getCombination(long n) {
        return n % 2 == 0 ? (n / 2) * (n + 1) : n * ((n + 1) / 2);
    }
}
