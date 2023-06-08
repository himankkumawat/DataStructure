package com.himank.leetcode.problems;

public class Problem1351 {

    // https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
    public static void main(String[] args) {
        int[][] matrix = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println("Negative numbers in sorted matrix : " + countNegatives(matrix));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        int currRowNegativeIndex = n - 1;

        for (int[] row : grid) {
            while (currRowNegativeIndex >= 0 && row[currRowNegativeIndex] < 0) {
                currRowNegativeIndex--;
            }
            count += (n - (currRowNegativeIndex + 1));
        }
        return count;
    }
}
