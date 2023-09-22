package com.himank.leetcode.problems;

public class Problem392 {

    // https://leetcode.com/problems/is-subsequence/
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        System.out.println("Is sub sequence : " + isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int leftBound = s.length(), rightBound = t.length();
        int pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
}
