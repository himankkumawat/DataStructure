package com.himank.leetcode.problems;

public class Problem2849 {

    // https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
    public static void main(String[] args) {
        int sx = 2, sy = 4, fx = 7, fy = 7, t = 6;
        System.out.println("Can a cell be reached? " + isReachableAtTime(sx, sy, fx, fy, t));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);
        if (width == 0 && height == 0 && t == 1) {
            return false;
        }
        return t >= Math.max(width, height);
    }
}
