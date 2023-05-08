package com.himank.leetcode.problems;

public class Problem1572 {

    // https://leetcode.com/problems/matrix-diagonal-sum/
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println("Sum of diagonal element : " + diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;

        int j = mat.length - 1;

        for(int i = 0; i < mat.length && j >= 0; i++) {
            if (i == j && mat.length % 2 == 1) {
                sum = sum + mat[i][i];
            } else {
                sum = sum + mat[i][i] + mat[i][j];
            }
            j--;
        }
        return sum;
    }
}
