package com.himank.leetcode.problems;

public class Problem1704 {

    // https://leetcode.com/problems/determine-if-string-halves-are-alike/
    public static void main(String[] args) {
        String s = "book";
        System.out.println("Is halves are alike? : " + halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        final String a = s.substring(0, s.length() / 2);
        final String b = s.substring(s.length() / 2);
        final int aVowelsCount = (int) a.chars().filter(c -> isVowel((char) c)).count();
        final int bVowelsCount = (int) b.chars().filter(c -> isVowel((char) c)).count();
        return aVowelsCount == bVowelsCount;
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
