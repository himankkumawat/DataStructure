package com.himank.leetcode.problems;

public class Problem208 {

    // https://leetcode.com/problems/implement-trie-prefix-tree/
    public static void main(String[] args) {
        Problem208 trie = new Problem208();
        trie.insert("apple");
        System.out.println("Found apple? " + trie.search("apple"));
        System.out.println("Found app? " + trie.search("app"));
        System.out.println("starts with app? " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("Found app? " + trie.search("app"));
    }

    boolean endOfWord;
    Problem208[] children;

    public Problem208() {
        endOfWord = false;
        children = new Problem208[26];
    }

    public void insert(String word) {
        Problem208 temp = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new Problem208();
            }

            temp = temp.children[index];
        }
        temp.endOfWord = true;
    }

    public boolean search(String word) {
        Problem208 temp = searchPrefix(word);
        return temp != null && temp.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Problem208 temp = searchPrefix(prefix);
        return temp != null;
    }

    public Problem208 searchPrefix(String prefix) {
        Problem208 temp = this;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (temp.children[idx] == null) {
                return null;
            }
            temp = temp.children[idx];
        }
        return temp;
    }
}
