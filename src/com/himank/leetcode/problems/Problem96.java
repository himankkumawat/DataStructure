package com.himank.leetcode.problems;

public class Problem96 {

    // https://leetcode.com/problems/unique-binary-search-trees/
    public static void main(String[] args) {
        System.out.println("Total unique binary tree possible are : " + numTrees(5));
    }

    public static int numTrees(int n) {
        long catalan = 1;
        for (int i = 0; i < n; i++) {
            catalan = catalan * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) catalan;
    }
}
