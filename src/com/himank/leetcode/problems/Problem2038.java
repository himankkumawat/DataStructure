package com.himank.leetcode.problems;

public class Problem2038 {

    // https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
    public static void main(String[] args) {
        String colors = "AAABABB";
        System.out.println("Winner is  : " + (winnerOfGame(colors) ? "Alice" : "Bob"));
    }

    public static boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;

        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }

        return alice - bob >= 1;
    }
}
