package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1347 {

    // https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
    public static void main(String[] args) {
        String s = "leetcode", t = "practice";
        System.out.println("Minimum steps are : " + minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        int[] count = new int[26];

        for (final char c : s.toCharArray())
            ++count[c - 'a'];

        for (final char c : t.toCharArray())
            --count[c - 'a'];

        return Arrays.stream(count).map(Math::abs).sum() / 2;
    }
}
