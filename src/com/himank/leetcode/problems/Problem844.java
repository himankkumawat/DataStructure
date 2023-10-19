package com.himank.leetcode.problems;

import java.util.Stack;

public class Problem844 {

    // https://leetcode.com/problems/backspace-string-compare/
    public static void main(String[] args) {
        String s = "ab##", t = "c#d#";
        System.out.println("Strings are same same in editor : " + backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        Stack<Character> ans = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
