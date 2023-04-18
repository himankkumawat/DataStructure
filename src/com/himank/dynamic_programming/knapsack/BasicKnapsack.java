package com.himank.dynamic_programming.knapsack;

public class BasicKnapsack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int w = 7;

        System.out.println("maximum value using recursion : " + knapsackRecursion(weight, value, w, weight.length));
        System.out.println("maximum value using memoization : " + knapsackMemoization(weight, value, w, weight.length));
        System.out.println("maximum value using top down : " + knapsackTopDown(weight, value, w, weight.length));
    }

    public static int knapsackTopDown(int[] weight, int[] values, int w, int n) {
        int[][] topDownDP = new int[n + 1][w + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] <= j) {
                    topDownDP[i][j] = Math.max(values[i - 1] + topDownDP[i - 1][j - weight[i - 1]],
                            topDownDP[i - 1][j]);
                } else {
                    topDownDP[i][j] = topDownDP[i - 1][j];
                }
            }
        }

        return topDownDP[n][w];
    }

    public static int knapsackRecursion(int[] weight, int[] values, int w, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (weight[n - 1] > w)
            return knapsackRecursion(weight, values, w, n - 1);

        return Math.max(values[n - 1] + knapsackRecursion(weight, values, w - weight[n - 1], n - 1),
                knapsackRecursion(weight, values, w, n - 1));
    }

    static int[][] dp = new int[4 + 1][7 + 1];                      // This is hardcoded for the example taken above.

    static {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
    }

    public static int knapsackMemoization(int[] weight, int[] values, int w, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (dp[n][w] != -1)
            return dp[n][w];

        if (weight[n - 1] > w)
            return dp[n][w] = knapsackMemoization(weight, values, w, n - 1);

        return dp[n][w] = Math.max(values[n - 1] + knapsackMemoization(weight, values, w - weight[n - 1], n - 1),
                knapsackMemoization(weight, values, w, n - 1));
    }
}
