package com.himank.leetcode.problems;

public class Problem7 {

    // https://leetcode.com/problems/reverse-integer/description/
    public static void main(String[] args) {
        int no= 1534236469;
        System.out.println("Reverse: " + reverse(no));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int rem = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && rem > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && rem < -8)) return 0;
            rev = rev * 10 + rem;
        }
        return rev;
    }
}
