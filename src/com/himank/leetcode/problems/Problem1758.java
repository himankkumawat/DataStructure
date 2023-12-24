package com.himank.leetcode.problems;

public class Problem1758 {

    // https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
    public static void main(String[] args) {
        String s = "0100";
        System.out.println("Minimum Changes To Make Alternating Binary String : " + minOperations(s));
    }

    public static int minOperations(String s) {
        int start0 = 0;
        int start1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }

        return Math.min(start0, start1);
    }
}
