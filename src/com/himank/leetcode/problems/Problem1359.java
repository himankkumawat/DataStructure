package com.himank.leetcode.problems;

public class Problem1359 {

    // https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Count of all valid pickup and delivery options: " + countOrders(n));
    }


    public static int countOrders(int n) {
        long ans = 1;
        int MOD = 1_000_000_007;

        for (int i = 1; i <= n; ++i) {
            ans = ans * i;
            ans = ans * (2 * i - 1);
            ans %= MOD;
        }

        return (int) ans;
    }


}
