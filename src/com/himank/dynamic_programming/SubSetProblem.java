package com.himank.dynamic_programming;

public class SubSetProblem {

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int targetSum = 14;
        System.out.println("Target sum is possible? : " + isSubSetSumExist(arr, targetSum));
    }

    public static boolean isSubSetSumExist(int[] arr, int targetSum) {
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][targetSum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < targetSum + 1; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][targetSum];

    }
}
