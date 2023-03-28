package com.himank.leetcode.problems;

import java.util.HashSet;

public class Problem983 {

    // https://leetcode.com/problems/minimum-cost-for-tickets/
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20}, costs = {2, 7, 15};
        System.out.println("Minimum cost = " + mincostTickets(days, costs));
    }

    static int[] cost;
    static Integer[] memo;
    static HashSet<Integer> dayset = new HashSet<>();

    public static int mincostTickets(int[] days, int[] costs) {
        cost = costs;
        memo = new Integer[366];

        for (int d : days) dayset.add(d);

        return dp(1);
    }

    public static int dp(int i) {
        if (i > 365)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        if (dayset.contains(i)) {
            ans = Math.min(dp(i + 1) + cost[0],
                    dp(i + 7) + cost[1]);
            ans = Math.min(ans, dp(i + 30) + cost[2]);
        } else {
            ans = dp(i + 1);
        }

        memo[i] = ans;
        return ans;
    }
}
