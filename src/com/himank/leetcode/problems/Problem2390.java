package com.himank.leetcode.problems;

import java.util.Stack;

public class Problem2390 {

    // https://leetcode.com/problems/removing-stars-from-a-string/
    public static void main(String[] args) {
        String st = "leet**cod*e";
        System.out.println("Result : " + removeStars(st));
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Character ch : stack) {
            answer.append(ch);
        }

        return answer.toString();
    }
}
