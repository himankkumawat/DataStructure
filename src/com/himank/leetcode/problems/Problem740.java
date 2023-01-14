package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem740 {
    public static void main(String[] args) {
//        int[] arr = {3, 4, 2};
        int[] arr = {2, 2, 3, 3, 3, 4};
        System.out.println("Max value of delete and earn: " + deleteAndEarn(arr));
    }

    private static Map<Integer, Integer> priceMap = new HashMap<>();
    private static Map<Integer, Integer> maxEarn = new HashMap<>();

    public static int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        for (int n : nums) {
            int cost = priceMap.getOrDefault(n, 0);
            priceMap.put(n, cost + n);
            maxNumber = Math.max(maxNumber, n);
        }

        return deleteAndEarnDP(maxNumber);
    }

    private static int deleteAndEarnDP(int number) {
        if (number == 0) return 0;
        if (number == 1) return priceMap.getOrDefault(1, 0);

        if (!maxEarn.containsKey(number)) {
            maxEarn.put(number, Math.max(deleteAndEarnDP(number - 1),
                    deleteAndEarnDP(number - 2) + priceMap.getOrDefault(number, 0)));
        }
        return maxEarn.get(number);
    }
}
