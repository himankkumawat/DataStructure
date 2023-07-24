package com.himank.leetcode.problems;

public class Problem50 {

    // https://leetcode.com/problems/powx-n/description/
    public static void main(String[] args) {
        double x = 2.000000;
        int n = 10;
        System.out.println("Result : " + myPow(x, n));
    }

    private static double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }

        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        } else {
            return binaryExp(x * x, n / 2);
        }
    }

    public static double myPow(double x, int n) {
        return binaryExp(x, n);
    }
}
