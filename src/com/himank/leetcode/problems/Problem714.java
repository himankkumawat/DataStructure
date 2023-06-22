package com.himank.leetcode.problems;

public class Problem714 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fees = 2;
        System.out.println("Maximum profit = " + maxProfit(prices, fees));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] free = new int[n], hold = new int[n];

        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        }

        return free[n - 1];
    }
}
