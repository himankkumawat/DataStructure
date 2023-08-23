package com.himank.leetcode.problems;

import java.util.PriorityQueue;

public class Problem767 {

    // https://leetcode.com/problems/reorganize-string/description/
    public static void main(String[] args) {
        String str = "aab";
        System.out.println("Reorganize string: " + reorganizeString(str));
    }

    public static String reorganizeString(String s) {
        var charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a'] = charCounts[c - 'a'] + 1;
        }

        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.offer(new int[] {i + 'a', charCounts[i]});
            }
        }

        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.offer(first);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                var second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.offer(second);
                }

                pq.offer(first);
            }
        }

        return sb.toString();
    }
}
