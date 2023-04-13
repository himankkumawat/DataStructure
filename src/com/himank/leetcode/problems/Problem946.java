package com.himank.leetcode.problems;

import java.util.Stack;

public class Problem946 {

    public static void main(String[] args) {
//        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 5, 3, 2, 1};
        int[] pushed = {2, 1, 0}, popped = {1, 2, 0};
        System.out.println("Is stack sequence valid? : " + validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        int popIndex = 0;
        for (int i = 1; i < pushed.length; i++) {
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
            stack.push(pushed[i]);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != popped[popIndex])
                return false;
            stack.pop();
            popIndex++;
        }
        return true;
    }
}
