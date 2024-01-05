package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem300 {

    // https://leetcode.com/problems/longest-increasing-subsequence
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Longest increasing subsequence: " + lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        // tails[i] := the minimum tail of all the increasing subsequences having
        // length i + 1
        // It's easy to see that `tails` must be an increasing array.
        List<Integer> tails = new ArrayList<>();

        for (final int num : nums)
            if (tails.isEmpty() || num > tails.get(tails.size() - 1))
                tails.add(num);
            else
                tails.set(firstGreaterEqual(tails, num), num);

        return tails.size();
    }

    private static int firstGreaterEqual(List<Integer> A, int target) {
        final int i = Collections.binarySearch(A, target);
        return i < 0 ? -i - 1 : i;
    }
}
