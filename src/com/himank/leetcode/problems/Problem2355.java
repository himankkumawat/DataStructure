package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

public class Problem2355 {

    // https://leetcode.com/problems/maximum-number-of-books-you-can-take/
    public static void main(String[] args) {
        int[] books = {8, 5, 2, 7, 9};
        System.out.println("Maximum number of books you can take : " + maximumBooks(books));
    }

    public static long maximumBooks(int[] books) {
        int n = books.length;

        Stack<Integer> s = new Stack<>();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && books[s.peek()] - s.peek() >= books[i] - i) {
                s.pop();
            }

            if (s.isEmpty()) {
                dp[i] = calculateSum(books, 0, i);
            } else {
                int j = s.peek();
                dp[i] = dp[j] + calculateSum(books, j + 1, i);
            }

            s.push(i);
        }

        return Arrays.stream(dp).max().getAsLong();
    }

    private static long calculateSum(int[] books, int l, int r) {
        long cnt = Math.min(books[r], r - l + 1);
        return (2 * books[r] - (cnt - 1)) * cnt / 2;
    }
}
