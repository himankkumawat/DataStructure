package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem455 {

    // https://leetcode.com/problems/assign-cookies/
    public static void main(String[] args) {
        int[] g = {1,2,3}, s = {1,1};
        System.out.println("Assigning cookies to children: " + findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        for (int j = 0; i < g.length && j < s.length; ++j)
            if (g[i] <= s[j])
                ++i;

        return i;
    }
}
