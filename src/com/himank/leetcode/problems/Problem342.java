package com.himank.leetcode.problems;

public class Problem342 {

    // https://leetcode.com/problems/power-of-four/
    public static void main(String[] args) {
        int no = 16;
        System.out.println("Number is power of 4? " + isPowerOfFour(no));
    }

    public static boolean isPowerOfFour(int n) {
        return ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}
