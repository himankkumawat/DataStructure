package com.himank.leetcode.problems;

public class Problem70 {

    // https://leetcode.com/problems/climbing-stairs/
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Total ways to climb a stairs are : " + climbStairs(n));
    }

    public static int climbStairs(int n) {
        int a = 1, b = 2;
        if (n <= 2)
            return n;
        int c = a + b;
        int count = 4;
        while (count <= n) {
            count++;
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
