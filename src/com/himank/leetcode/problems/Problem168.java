package com.himank.leetcode.problems;

public class Problem168 {

    // https://leetcode.com/problems/excel-sheet-column-title/description/
    public static void main(String[] args) {
        System.out.println("Excel sheet column : " + convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            ans.append((char) ((columnNumber) % 26 + 'A'));
            columnNumber = (columnNumber) / 26;
        }
        return ans.reverse().toString();
    }
}
