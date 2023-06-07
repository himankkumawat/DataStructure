package com.himank.leetcode.problems;

public class Problem1318 {

    // https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
    public static void main(String[] args) {
        int a = 2, b = 6, c = 5;
        System.out.println("Minimum flips : " + minFlips(a, b, c));
    }

    public static int minFlips(int a, int b, int c) {
        int answer = 0;
        while (a != 0 | b != 0 | c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    answer++;
                }
            } else {
                answer += (a & 1) + (b & 1);
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return answer;
    }
}
