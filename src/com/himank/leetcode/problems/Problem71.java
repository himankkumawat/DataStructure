package com.himank.leetcode.problems;

import java.util.Stack;

public class Problem71 {

    // https://leetcode.com/problems/simplify-path/
    public static void main(String[] args) {
        String path = "/home/";
        System.out.println("Simplify path : " + simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (!directory.equals(".") && !directory.isEmpty()) {
                if (directory.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.add(directory);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/" ;
    }
}
