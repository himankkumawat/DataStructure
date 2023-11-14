package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1930 {

    /// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
    public static void main(String[] args) {
        String str = "aabca";
        System.out.println("Number of unique palindrome strings are: " + countPalindromicSubsequence(str));
    }

    public static int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == - 1) {
                first[curr] = i;
            }

            last[curr] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            Set<Character> between = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }

            ans += between.size();
        }

        return ans;
    }
}
