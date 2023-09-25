package com.himank.leetcode.problems;

import java.util.HashMap;

public class Problem389 {

    // https://leetcode.com/problems/find-the-difference/
    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println("extra character is : " + findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {

        char extraChar = '\0';

        HashMap<Character, Integer> counterS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counterS.put(ch, counterS.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i += 1) {
            char ch = t.charAt(i);
            int countOfChar = counterS.getOrDefault(ch, 0);
            if (countOfChar == 0) {
                extraChar = ch;
                break;
            } else {
                counterS.put(ch, countOfChar - 1);
            }
        }
        return extraChar;
    }

}
