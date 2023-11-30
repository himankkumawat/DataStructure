package com.himank.leetcode.problems;

public class Problem1611 {

    // https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Minimum One Bit Operations to Make Integers Zero : " + minimumOneBitOperations(n));
    }

    public static int minimumOneBitOperations(int n) {
        int ans = 0;
        int k = 0;
        int mask = 1;

        while (mask <= n) {
            if ((n & mask) != 0) {
                ans = (1 << (k + 1)) - 1 - ans;
            }
            mask <<= 1;
            k++;
        }
        return ans;
    }
}
