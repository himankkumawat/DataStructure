package com.himank.leetcode.problems;

public class Problem1913 {

    // https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
        System.out.println("Maximum product difference b/w 2 pairs: " + maxProductDifference(nums));
    }

    public static int maxProductDifference(int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest, num);
            }
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else {
                secondSmallest = Math.min(secondSmallest, num);
            }
        }
        return biggest * secondBiggest - smallest * secondSmallest;
    }
}
