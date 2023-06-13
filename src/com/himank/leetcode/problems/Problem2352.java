package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2352 {

    // https://leetcode.com/problems/equal-row-and-column-pairs/description/
    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println("Total number of equal pairs : " + equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}
