package com.himank.leetcode.problems;

public class Problem1732 {

    // https://leetcode.com/problems/find-the-highest-altitude/
    public static void main(String[] args) {
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Maximum altitude : " + largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int max = gain[0];
        int sum = gain[0];
        for (int i = 1; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(max, sum);
        }
        return Math.max(max, 0);
    }
}
