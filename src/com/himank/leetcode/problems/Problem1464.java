package com.himank.leetcode.problems;

public class Problem1464 {

    // https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 5};
        System.out.println("Maximum product of two elements in array: " + maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        for (int num : nums) {
            if (num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest, num);
            }
        }
        return (biggest - 1) * (secondBiggest - 1);
    }
}
