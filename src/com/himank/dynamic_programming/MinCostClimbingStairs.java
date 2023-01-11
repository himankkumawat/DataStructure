package com.himank.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        System.out.println("Min cost of climbing: " + minCostClimbingStairs(arr, arr.length));
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
