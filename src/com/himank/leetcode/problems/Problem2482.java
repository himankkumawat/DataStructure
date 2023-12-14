package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2482 {

    // https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        int[][] result = onesMinusZeros(grid);
        Arrays.stream(result).forEach(row -> {
            Arrays.stream(row).forEach(x -> System.out.print(x + "  "));
            System.out.println();
        });
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] onesRow = new int[m];
        int[] onesCol = new int[n];

        Arrays.fill(onesRow, 0);
        Arrays.fill(onesCol, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }

        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = 2 * onesRow[i] + 2 * onesCol[j] - n - m;
            }
        }

        return diff;
    }
}
