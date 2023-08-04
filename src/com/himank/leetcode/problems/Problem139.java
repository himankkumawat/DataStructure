package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem139 {

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println("Word break exist? : " + wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }

                curr = curr.children.get(c);
            }

            curr.isWord = true;
        }

        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i - 1]) {
                TrieNode curr = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        break;
                    }

                    curr = curr.children.get(c);
                    if (curr.isWord) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }

    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
        }
    }
}
