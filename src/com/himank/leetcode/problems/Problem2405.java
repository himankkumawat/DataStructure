package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2405 {

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println("Optimal partitions are : " + partitionString(s));
    }

    public static int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        return count;
    }
}
