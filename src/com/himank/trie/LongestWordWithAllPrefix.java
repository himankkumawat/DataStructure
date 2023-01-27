package com.himank.trie;

public class LongestWordWithAllPrefix {

    private static TrieDS trieDS = new TrieDS();

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        trieDS.insert(words);

        getLongestWordWithPrefix(trieDS.root, new StringBuilder());
        System.out.println("Longest word with all prefix is: " + result);
    }

    private static String result = "";

    private static void getLongestWordWithPrefix(TrieNode root, StringBuilder sb) {
        if (root == null) return ;
        TrieNode current = root;

        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null && current.children[i].endOfWord) {
                sb.append((char) (i + 'a'));
                if (sb.toString().length() > result.length())
                    result = sb.toString();
                getLongestWordWithPrefix(current.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }

}
