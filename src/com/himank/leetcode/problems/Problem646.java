package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem646 {

    // https://leetcode.com/problems/maximum-length-of-pair-chain/
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Maximum length of pair chain: " + findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int curr = Integer.MIN_VALUE;
        int ans = 0;

        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                ans++;
                curr = pair[1];
            }
        }
        return ans;
    }
}
