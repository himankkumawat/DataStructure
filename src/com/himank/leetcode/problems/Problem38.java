package com.himank.leetcode.problems;

public class Problem38 {

    // https://leetcode.com/problems/count-and-say/
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Output is : " + countAndSay(n));
    }

    public static String countAndSay(int n) {
        String no = "1";
        if (n == 1) {
            return no;
        }
        while (n-- > 1) {
            no = getResult(no);
        }
        return no;
    }

    private static String getResult(String str) {
        if (str.equals("1")) return "11";
        String result = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0) {
                count++;
            } else if (i == str.length() - 1) {
                if (ch != str.charAt(i - 1)) {
                    result += String.valueOf(count) + str.charAt(i - 1);
                    count = 1;
                    result += String.valueOf(count) + str.charAt(i);
                } else {
                    count++;
                    result += String.valueOf(count) + str.charAt(i);
                }
            } else {
                if (ch != str.charAt(i - 1)) {
                    result += String.valueOf(count) + str.charAt(i - 1);
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        return result;
    }
}
