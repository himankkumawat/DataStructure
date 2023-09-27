package com.himank.leetcode.problems;

public class Problem880 {

    // https://leetcode.com/problems/decoded-string-at-index/
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        System.out.println("Decoded string is " + decodeAtIndex(s, k));
    }

    public static String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N - 1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        return null;
    }
}
