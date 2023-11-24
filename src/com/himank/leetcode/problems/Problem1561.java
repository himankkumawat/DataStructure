package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1561 {

    // https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
    public static void main(String[] args) {
        int[] piles = {2,4,1,2,7,8};
        System.out.println("Maximum number of coins : " + maxCoins(piles));
    }

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;

        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }

        return ans;
    }
}
