package com.himank.leetcode.problems;

public class Problem1688 {

    // https://leetcode.com/problems/count-of-matches-in-tournament/
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Number of matches in tournament: " + numberOfMatches(n));
    }

    public static int numberOfMatches(int n) {
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                ans += n / 2;
                n = n / 2;
            } else {
                ans += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return ans;
    }
}
