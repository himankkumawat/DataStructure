package com.himank.trie;

import java.util.ArrayList;
import java.util.List;

public class UniqueSubstring {

    private static TrieDS trieDS = new TrieDS();

    public static void main(String[] args) {
        String word = "apple";              // 15
//        String word = "ababa";            // 10

        insertAllSuffix(word);

        System.out.println("Total unique substring possible = " + countTotalNodes(trieDS.root));

    }

    private static void insertAllSuffix(String word) {
        for (int i = 0; i < word.length(); i++) {
            trieDS.insert(word.substring(i));
        }
    }

    private static int countTotalNodes(TrieNode root) {
        if (root == null) return 0;
        TrieNode current = root;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (current.children[i] != null)
                count += countTotalNodes(current.children[i]);
        }
        return count + 1;
    }


}
