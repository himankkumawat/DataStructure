package com.himank.leetcode.problems;

public class Problem242 {

    // https://leetcode.com/problems/valid-anagram/
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println("Are strings anagram? " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}