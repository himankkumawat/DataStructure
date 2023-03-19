package com.himank.leetcode.problems;

public class Problem211 {

    public static void main(String[] args) {
//        WordDictionary dictionary = new WordDictionary();
//        dictionary.addWord("bad");
//        dictionary.addWord("dad");
//        dictionary.addWord("mad");
//        System.out.println("Search word pad: " + dictionary.search("pad"));
//        System.out.println("Search word bad: " + dictionary.search("bad"));
//        System.out.println("Search word .ad: " + dictionary.search(".ad"));
//        System.out.println("Search word b..: " + dictionary.search("b.."));


        Problem211 dictionary = new Problem211();
        dictionary.addWord("a");
        dictionary.addWord("a");
        System.out.println("Search word .: " + dictionary.search("."));
        System.out.println("Search word a: " + dictionary.search("a"));
        System.out.println("Search word aa: " + dictionary.search("aa"));
        System.out.println("Search word a: " + dictionary.search("a"));
        System.out.println("Search word .a: " + dictionary.search(".a"));
        System.out.println("Search word a.: " + dictionary.search("a."));
    }

    TrieNode root;

    public Problem211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.endOfWord = true;
    }

    public boolean search(String word) {
        return searchWord(word, root);
    }

    public boolean searchWord(String word, TrieNode node) {
        TrieNode temp = node;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    TrieNode child = temp.children[j];
                    if (child != null && searchWord(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = ch - 'a';
                if (temp.children[index] == null)
                    return false;
                temp = temp.children[index];
            }
        }
        return temp.endOfWord;
    }

    public static class TrieNode {

        TrieNode[] children;

        boolean endOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }
}
