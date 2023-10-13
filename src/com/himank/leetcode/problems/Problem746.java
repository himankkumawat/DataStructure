package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem746 {

    // https://leetcode.com/problems/min-cost-climbing-stairs/
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost to climb the stairs : " + minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, cost.length);
    }

    private static Map<Integer, Integer> climbingCost = new HashMap<>();

    private static int minCostClimbingStairs(int[] cost, int index) {
        if (index <= 1) return 0;

        if (!climbingCost.containsKey(index)) {
            climbingCost.put(index, Math.min(minCostClimbingStairs(cost, index - 1) + cost[index - 1],
                    minCostClimbingStairs(cost, index - 2) + cost[index - 2]));
        }
        return climbingCost.get(index);

    }
}
