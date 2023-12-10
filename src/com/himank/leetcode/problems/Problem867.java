package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem867 {

    // https://leetcode.com/problems/transpose-matrix/
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = transpose(matrix);
        Arrays.stream(result).forEach(row -> {
            Arrays.stream(row).forEach(x -> System.out.print(x + "  "));
            System.out.println();
        });
    }

    public static int[][] transpose(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = matrix[r][c];
            }
        return ans;
    }
}
