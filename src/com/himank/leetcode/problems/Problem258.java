package com.himank.leetcode.problems;

public class Problem258 {

    // https://leetcode.com/problems/add-digits/
    public static void main(String[] args) {
        int number = 388634;
        System.out.println("Sum of digits are : " + addDigits(number));
    }

    public static int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
