package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1624 {

    // https://leetcode.com/problems/largest-substring-between-two-equal-characters/
    public static void main(String[] args) {
        String s = "abca";
        System.out.println("Largest Substring Between Two Equal Characters : " + maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        for (int i = 0; i < s.length(); ++i) {
            final int c = s.charAt(i) - 'a';
            if (lastSeen[c] == -1)
                lastSeen[c] = i;
            else
                ans = Math.max(ans, i - lastSeen[c] - 1);
        }
        return ans;
    }
}
