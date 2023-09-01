package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem338 {

    // https://leetcode.com/problems/counting-bits/
    public static void main(String[] args) {
        int n = 2;
        int[] result = countBits(n);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int x = 0;
        int b = 1;
        while (b <= n) {
            while (x < b && x + b <= n) {
                ans[x + b] = ans[x] + 1;
                ++x;
            }
            x = 0;
            b <<= 1;
        }

        return ans;
    }


}
