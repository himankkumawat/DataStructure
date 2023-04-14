package com.himank.leetcode.problems;

public class Problem28 {

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println("First occurrence is : " + strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
