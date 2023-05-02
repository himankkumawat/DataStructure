package com.himank.leetcode.problems;

public class Problem1822 {

    // https://leetcode.com/problems/sign-of-the-product-of-an-array/
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println("Sign of product of array is : " + arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int sign = 1;
        for(int ele : nums) {
            if(ele == 0) return 0;
            if (ele < 0) sign *= -1;
        }
        return sign;
    }
}
