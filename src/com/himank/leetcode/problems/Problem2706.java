package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2706 {

    // https://leetcode.com/problems/buy-two-chocolates/
    public static void main(String[] args) {
        int[] prices = {1, 2, 2};
        int money = 3;
        System.out.println("Leftover money: " + buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int minCost = prices[0] + prices[1];

        if (minCost <= money) {
            return money - minCost;
        }
        return money;
    }
}
