package com.himank.leetcode.problems;

public class Problem799 {

    // https://leetcode.com/problems/champagne-tower/
    public static void main(String[] args) {
        int poured = 2, query_row = 1, query_glass = 1;
        System.out.println("Champagne tower : " + champagneTower(poured, query_row, query_glass));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r + 1][c] += q;
                    A[r + 1][c + 1] += q;
                }
            }
        }

        return Math.min(1, A[query_row][query_glass]);
    }
}
