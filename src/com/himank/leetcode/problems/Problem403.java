package com.himank.leetcode.problems;

import java.util.HashMap;

public class Problem403 {

    // https://leetcode.com/problems/frog-jump/
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println("Can frog jump: " + canCross(stones));
    }

    private static HashMap<Integer, Integer> mark = new HashMap<>();
    private static boolean[][] dp = new boolean[2001][2001];

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            mark.put(stones[i], i);
        }

        dp[0][0] = true;
        for (int index = 0; index < n; index++) {
            for (int prevJump = 0; prevJump <= n; prevJump++) {
                // If stone exists, mark the value with position and jump as 1.
                if (dp[index][prevJump]) {
                    if (mark.containsKey(stones[index] + prevJump)) {
                        dp[mark.get(stones[index] + prevJump)][prevJump] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump + 1)) {
                        dp[mark.get(stones[index] + prevJump + 1)][prevJump + 1] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump - 1)) {
                        dp[mark.get(stones[index] + prevJump - 1)][prevJump - 1] = true;
                    }
                }


            }
        }

        // If any value with index as n - 1 is true, return true.
        for (int index = 0; index <= n; index++) {
            if (dp[n - 1][index]) {
                return true;
            }
        }
        return false;
    }
}
