package com.himank.leetcode.problems;

public class Problem1232 {

    // https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println("Is straight line : " + checkStraightLine(coordinates));
    }

    private static int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }

    private static int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int deltaY = getYDiff(coordinates[1], coordinates[0]);
        int deltaX = getXDiff(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
            if (deltaY * getXDiff(coordinates[i], coordinates[0]) != deltaX * getYDiff(coordinates[i], coordinates[0])) {
                return false;
            }
        }
        return true;
    }
}
