package com.himank.leetcode.problems;

public class Problem1716 {

    // https://leetcode.com/problems/calculate-money-in-leetcode-bank/
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Calculate Money in Leetcode Bank : " + totalMoneyNew(n));
    }

    public static int totalMoney(int n) {
        int ans = 0;
        int monday = 1;
        while (n > 0) {
            for (int day = 0; day < Math.min(n, 7); day++) {
                ans += monday + day;
            }
            n -= 7;
            monday++;
        }
        return ans;
    }

    public static int totalMoneyNew(int n) {
        int k = n / 7;
        int F = 28;
        int L = 28 + (k - 1) * 7;
        int arithmeticSum = k * (F + L) / 2;

        int monday = 1 + k;
        int finalWeek = 0;
        for (int day = 0; day < n % 7; day++) {
            finalWeek += monday + day;
        }
        return arithmeticSum + finalWeek;
    }
}
