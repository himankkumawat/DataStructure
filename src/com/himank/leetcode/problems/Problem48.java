package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem48 {

    // https://leetcode.com/problems/rotate-image/
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};

        rotate(matrix);

        Arrays.stream(matrix).forEach(System.out::println);
    }

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        rotateColumn(matrix);
    }

    private static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void rotateColumn(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
