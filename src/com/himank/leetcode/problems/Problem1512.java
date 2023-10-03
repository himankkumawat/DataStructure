package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem1512 {

    // https://leetcode.com/problems/number-of-good-pairs/description/
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println("Number of good pairs = " + numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            ans += counts.getOrDefault(num, 0);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        return ans;
    }
}
