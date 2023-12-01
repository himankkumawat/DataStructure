package com.himank.leetcode.problems;

public class Problem1662 {

    // https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        System.out.println("string array equivalent? : " + arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word1Pointer = 0, word2Pointer = 0;
        int string1Pointer = 0, string2Pointer = 0;

        while (word1Pointer < word1.length && word2Pointer < word2.length) {
            if (word1[word1Pointer].charAt(string1Pointer++) !=
                    word2[word2Pointer].charAt(string2Pointer++)) {
                return false;
            }
            if (string1Pointer == word1[word1Pointer].length()) {
                word1Pointer++;
                string1Pointer = 0;
            }
            if (string2Pointer == word2[word2Pointer].length()) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }
        return word1Pointer == word1.length && word2Pointer == word2.length;
    }
}
