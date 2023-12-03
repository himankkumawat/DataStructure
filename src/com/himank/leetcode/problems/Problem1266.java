package com.himank.leetcode.problems;

public class Problem1266 {

    // https://leetcode.com/problems/minimum-time-visiting-all-points/
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println("Minimum time to visit all points: " + minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];
            int targetX = points[i + 1][0];
            int targetY = points[i + 1][1];
            ans += Math.max(Math.abs(targetX - currX), Math.abs(targetY - currY));
        }

        return ans;
    }
}
