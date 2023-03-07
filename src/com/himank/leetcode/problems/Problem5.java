package com.himank.leetcode.problems;

public class Problem5 {

    // https://leetcode.com/problems/longest-palindromic-substring/
    public static void main(String[] args) {
        String s = "ababc";
        System.out.println("Longest palindrome string is: " + longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++) {
            int len1 = checkWithCenter(s, i,i);
            int len2 = checkWithCenter(s,i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end +1);
    }

    private static int checkWithCenter(String s, int left, int right) {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right++;
        }
        return right - left - 1;
    }
}
