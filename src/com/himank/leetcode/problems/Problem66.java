package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem66 {

    // https://leetcode.com/problems/plus-one/
    public static void main(String[] args) {
        int[] digits = {1,2,3};

        int[] answer = plusOne(digits);
        Arrays.stream(answer).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }

            else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
