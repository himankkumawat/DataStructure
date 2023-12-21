package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1637 {

    // https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
    public static void main(String[] args) {
        int[][] points = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        System.out.println("Widest Vertical Area Between Two Points Containing No Points : " + maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}
