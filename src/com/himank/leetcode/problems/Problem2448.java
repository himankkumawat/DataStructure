package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2448 {

    // https://leetcode.com/problems/minimum-cost-to-make-array-equal/description/
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};
        long minCosts = minCost(nums, cost);
        System.out.println("Minimum costs to make array equal : " + minCosts);
    }

    public static long minCost(int[] nums, int[] cost) {

        int n = nums.length;
        int[][] numsAndCost = new int[n][2];
        for (int i = 0; i < n; ++i) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost, Comparator.comparingInt(a -> a[0]));

        long[] prefixCost = new long[n];
        prefixCost[0] = numsAndCost[0][1];
        for (int i = 1; i < n; ++i)
            prefixCost[i] = numsAndCost[i][1] + prefixCost[i - 1];

        long totalCost = 0L;
        for (int i = 1; i < n; ++i)
            totalCost += (long) numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
        long answer = totalCost;

        for (int i = 1; i < n; ++i) {
            int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
            totalCost += prefixCost[i - 1] * gap;
            totalCost -= (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
            answer = Math.min(answer, totalCost);
        }

        return answer;
    }
}
