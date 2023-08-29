package com.himank.leetcode.problems;

public class Problem2483 {

    // https://leetcode.com/problems/minimum-penalty-for-a-shop/
    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println("Minimum penalty for a shop : " + bestClosingTime(customers));
    }

    public static int bestClosingTime(String customers) {
        int curPenalty = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                curPenalty++;
            }
        }

        int minPenalty = curPenalty;
        int earliestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            if (ch == 'Y') {
                curPenalty--;
            } else {
                curPenalty++;
            }
            if (curPenalty < minPenalty) {
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }
        return earliestHour;
    }
}
