package com.himank.leetcode.problems;

public class Problem1503 {

    // https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
    public static void main(String[] args) {
        int n = 4;
        int[] left = {4, 3}, right = {0, 1};
        System.out.println("Last moment before all ants fall out of plank: " + getLastMoment(n, left, right));
    }

    public static int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int num : left) {
            ans = Math.max(ans, num);
        }

        for (int num : right) {
            ans = Math.max(ans, n - num);
        }

        return ans;
    }
}
