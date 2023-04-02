package com.himank.leetcode.problems;

import java.util.Stack;

public class Problem20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println("Is valid paranthesis? " + isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                characterStack.push(ch);
            } else if (!characterStack.empty() && ((ch == ')' && characterStack.peek() == '(') ||
                    (ch == '}' && characterStack.peek() == '{') || (ch == ']' && characterStack.peek() == '['))) {
                characterStack.pop();
            } else {
                return false;
            }
        }

        return characterStack.empty();
    }
}
