package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1751 {

    // https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/
    public static void main(String[] args) {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int k = 2;
        System.out.println("maximum sum = " + maxValue(events, k));
    }

    public static int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int maxValue(int[][] events, int k) {
        int n = events.length;
        int[][] dp = new int[k + 1][n + 1];
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        for (int curIndex = n - 1; curIndex >= 0; --curIndex) {
            int nextIndex = bisectRight(events, events[curIndex][1]);
            for (int count = 1; count <= k; count++) {
                dp[count][curIndex] = Math.max(dp[count][curIndex + 1], events[curIndex][2] + dp[count - 1][nextIndex]);
            }
        }
        return dp[k][0];
    }
}
