package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1575 {

    // https://leetcode.com/problems/count-all-possible-routes/description/
    public static void main(String[] args) {
        int[] locations = {2, 3, 6, 8, 4};
        int start = 1, finish = 3, fuel = 5;
        System.out.println("All possible routes : " + countRoutes(locations, start, finish, fuel));
    }

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        Arrays.fill(dp[finish], 1);

        int ans = 0;
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) %
                                1000000007;
                    }
                }
            }
        }

        return dp[start][fuel];
    }
}
