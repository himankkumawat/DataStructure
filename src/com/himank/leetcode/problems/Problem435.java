package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435 {

    // https://leetcode.com/problems/non-overlapping-intervals/description/
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Number of intervals to be removed: " + eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            int x = interval[0];
            int y = interval[1];

            if (x >= k) {
                k = y;
            } else {
                ans++;
            }
        }

        return ans;
    }
}
