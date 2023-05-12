package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem59 {

    // https://leetcode.com/problems/spiral-matrix-ii/
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);

        Arrays.stream(matrix).forEach(row -> {
            for (int ele : row)
                System.out.print(ele + "  ");
            System.out.println();
        });
    }

    public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        insertValueInMat(mat, 0, 0, 1, 'r');
        return mat;
    }

    private static void insertValueInMat(int[][] mat, int i, int j, int value, char dir) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat.length) return;

        if (mat[i][j] != 0) return;

        mat[i][j] = value;

        if (dir == 'u') {
            insertValueInMat(mat, i - 1, j, value + 1, 'u');
        }

        insertValueInMat(mat, i, j + 1, value + 1, 'r');
        insertValueInMat(mat, i + 1, j, value + 1, 'd');
        insertValueInMat(mat, i, j - 1, value + 1, 'l');
        insertValueInMat(mat, i - 1, j, value + 1, 'u');
    }
}
