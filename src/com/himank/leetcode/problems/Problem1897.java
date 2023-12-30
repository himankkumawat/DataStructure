package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1897 {

    // https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        System.out.println("Redistribute Characters to Make All Strings Equal : " + makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {
        int[] count = new int[26];

        for (final String word : words)
            for (final char c : word.toCharArray())
                ++count[c - 'a'];

        return Arrays.stream(count).allMatch(c -> c % words.length == 0);
    }
}
