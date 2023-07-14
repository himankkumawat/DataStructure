package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem1218 {

    // https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int difference = -2;
        System.out.println("Longest sequence with given difference : " + longestSubsequence(arr, difference));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1;

        for (int a : arr) {
            int beforeA = dp.getOrDefault(a - difference, 0);
            dp.put(a, beforeA + 1);
            answer = Math.max(answer, dp.get(a));
        }

        return answer;
    }
}
