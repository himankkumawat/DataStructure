package com.himank.leetcode.problems;

public class Problem1759 {

    // https://leetcode.com/problems/count-number-of-homogenous-substrings/
    public static void main(String[] args) {
        String str = "abbcccaa";
        System.out.println("Number of homogenous substring : " + countHomogenous(str));
    }

    public static int countHomogenous(String s) {
        int ans = 0;
        int currStreak = 0;
        int MOD = (int) 1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                currStreak++;
            } else {
                currStreak = 1;
            }

            ans = (ans + currStreak) % MOD;
        }

        return ans;
    }
}
