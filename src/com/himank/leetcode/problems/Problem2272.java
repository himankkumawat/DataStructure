package com.himank.leetcode.problems;

public class Problem2272 {

    // https://leetcode.com/problems/substring-with-largest-variance/description/
    public static void main(String[] args) {
        String str = "aababbb";
        System.out.println("Largest variance are: " + largestVariance(str));
    }

    public static int largestVariance(String s) {
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[ch - 'a']++;
        }
        int globalMax = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }

                char major = (char) ('a' + i);
                char minor = (char) ('a' + j);
                int majorCount = 0;
                int minorCount = 0;

                int restMinor = counter[j];

                for (char ch : s.toCharArray()) {
                    if (ch == major) {
                        majorCount++;
                    }
                    if (ch == minor) {
                        minorCount++;
                        restMinor--;
                    }

                    if (minorCount > 0)
                        globalMax = Math.max(globalMax, majorCount - minorCount);

                    if (majorCount < minorCount && restMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }

        return globalMax;
    }
}
