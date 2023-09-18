package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1337 {

    // https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};

        int k = 3;

        int[] result = kWeakestRows(mat, k);
        Arrays.stream(result).forEach(x -> System.out.print(x + "  "));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int [] indexes = new int[k];
        int nextInsertIndex = 0;

        for (int c = 0; c < n && nextInsertIndex < k; c++) {
            for (int r = 0; r < m && nextInsertIndex < k; r++) {
                if (mat[r][c] == 0 && (c == 0 || mat[r][c - 1] == 1)) {
                    indexes[nextInsertIndex] = r;
                    nextInsertIndex++;
                }
            }
        }
        for (int r = 0; nextInsertIndex < k ; r++) {
            if (mat[r][n - 1] == 1) {
                indexes[nextInsertIndex] = r;
                nextInsertIndex++;
            }
        }

        return indexes;
    }
}
