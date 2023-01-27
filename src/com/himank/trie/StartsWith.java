package com.himank.trie;

public class StartsWith {

    private static TrieDS trieDS = new TrieDS();

    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};
        String prefix = "ap";

        trieDS.insert(words);

        boolean isPrefixFound = startsWith(prefix);
        System.out.println("Prefix found? " + isPrefixFound);
    }

    private static boolean startsWith(String prefix) {
        TrieNode current = trieDS.root;

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null)
                return false;

            current = current.children[index];
        }

        return true;
    }
}
