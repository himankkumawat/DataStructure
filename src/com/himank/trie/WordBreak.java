package com.himank.trie;

public class WordBreak {

    private static TrieDS trieDS = new TrieDS();

    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String check = "ilikesamsungicemobile";

        trieDS.insert(words);

        boolean isWordBreakPossible = wordBreak(check);
        System.out.println("Word break is possible? " + isWordBreakPossible);
    }

    public static boolean wordBreak(String word) {
        if (word.length() == 0)
            return true;

        for (int i = 0; i < word.length(); i++) {
            if (trieDS.search(word.substring(0, i + 1)) && wordBreak(word.substring(i + 1)))
                return true;
        }

        return false;
    }
}
