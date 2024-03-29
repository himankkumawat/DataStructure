package com.himank.leetcode.problems;

public class Problem2147 {

    // https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        System.out.println("Number of Ways to Divide a Long Corridor: " + numberOfWays(corridor));
    }

    public static int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int[][] count = new int[corridor.length() + 1][3];

        count[corridor.length()][0] = 0;
        count[corridor.length()][1] = 0;
        count[corridor.length()][2] = 1;

        for (int index = corridor.length() - 1; index >= 0; index--) {
            if (corridor.charAt(index) == 'S') {
                count[index][0] = count[index + 1][1];
                count[index][1] = count[index + 1][2];
                count[index][2] = count[index + 1][1];
            } else {
                count[index][0] = count[index + 1][0];
                count[index][1] = count[index + 1][1];
                count[index][2] = (count[index + 1][0] + count[index + 1][2]) % MOD;
            }
        }
        return count[0][0];
    }
}
