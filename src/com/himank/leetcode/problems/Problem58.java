package com.himank.leetcode.problems;

public class Problem58 {

    // https://leetcode.com/problems/length-of-last-word/
    public static void main(String[] args) {
        String s = "luffy is still joyboy";

        System.out.println("Length of last word : " + lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = " " + s;
        char[] ch = s.toCharArray();
        int length = 0;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] != ' ' && ch[i - 1] == ' ') {
                length = 0;
                while (i < ch.length && ch[i] != ' ') {
                    length++;
                    i++;
                }
            }
        }
        return length;
    }
}
