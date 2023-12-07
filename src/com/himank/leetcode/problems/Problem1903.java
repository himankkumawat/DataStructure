package com.himank.leetcode.problems;

public class Problem1903 {

    // https://leetcode.com/problems/largest-odd-number-in-string/
    public static void main(String[] args) {
        String number = "35427";
        System.out.println("Largest Odd Number in String : " + largestOddNumber(number));
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
