package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2433 {

    // https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
    public static void main(String[] args) {
        int[] pref = {5, 2, 0, 3, 1};
        System.out.println("Original array of prefix xor: ");
        Arrays.stream(findArray(pref)).forEach(System.out::println);
    }

    public static int[] findArray(int[] pref) {
        int n = pref.length;

        int[] arr = new int[n];
        arr[0] = pref[0];
        for (int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }

        return arr;
    }
}
