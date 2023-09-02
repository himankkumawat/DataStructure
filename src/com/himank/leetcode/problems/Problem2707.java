package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem2707 {

    // https://leetcode.com/problems/extra-characters-in-a-string/
    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        System.out.println("Extra character in string : " + minExtraChar(s, dictionary));

    }

    public static int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        var root = buildTrie(dictionary);
        var dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            var node = root;
            for (int end = start; end < n; end++) {
                if (!node.children.containsKey(s.charAt(end))) {
                    break;
                }
                node = node.children.get(s.charAt(end));
                if (node.isWord) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }

    private static TrieNode buildTrie(String[] dictionary) {
        var root = new TrieNode();
        for (var word : dictionary) {
            var node = root;
            for (var c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }
        return root;
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}
