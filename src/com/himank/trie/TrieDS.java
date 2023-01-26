package com.himank.trie;

public class TrieDS {

    public static void main(String[] args) {
        String[] words = {"there", "the", "their", "an", "any"};
        TrieDS trieDS = new TrieDS();

        trieDS.insert(words);
        System.out.println("************************ Insertion done ************************");
        System.out.println();

        trieDS.printWords();
        System.out.println("************************ Printing done ************************");
        System.out.println();

        boolean wordFound = trieDS.search("ann");
        System.out.println("Word found? " + wordFound);
        System.out.println("************************ Searching done ************************");
        System.out.println();
    }

    class TrieNode {

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

    TrieNode root;

    public TrieDS() {
        root = new TrieNode();
    }

    public void insert(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            if (i == word.length() - 1) {
                current.children[index].endOfWord = true;
            }

            current = current.children[index];
        }
    }

    public void printWords() {
        printWords("", root);
    }

    private void printWords(String prefix, TrieNode root) {
        if (root == null) return;
        TrieNode currentNode = root;
        if (currentNode.endOfWord) {
            System.out.println("Word found: " + (prefix));
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (currentNode.children[i] != null) {
                printWords(prefix + ch, root.children[i]);
            }
        }
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null)
                return false;

            if (i == word.length() - 1 && current.children[index].endOfWord)
                return true;

            current = current.children[index];
        }
        return false;
    }

}

