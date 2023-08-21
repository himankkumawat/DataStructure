package com.himank.leetcode.problems;

public class Problem459 {

    // https://leetcode.com/problems/repeated-substring-pattern/description/
    public static void main(String[] args) {
        String str = "abcabcabcabc";
        System.out.println("Is substring repeated : " + repeatedSubstringPattern(str));
    }

    public static boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        return t.substring(1, t.length() - 1).contains(s);
    }
}
