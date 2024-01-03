package com.himank.leetcode.problems;

public class Problem2125 {

    // https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
    public static void main(String[] args) {
        String[] bank = {"011001", "000000", "010100", "001000"};
        System.out.println("Number of laser beam in bank: " + numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int ans = 0;
        int prevOnes = 0;

        for (final String row : bank) {
            final int ones = (int) row.chars().filter(c -> c == '1').count();
            if (ones > 0) {
                ans += prevOnes * ones;
                prevOnes = ones;
            }
        }
        return ans;
    }
}
