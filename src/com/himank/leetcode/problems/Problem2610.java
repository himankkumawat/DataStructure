package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem2610 {

    // https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> result = findMatrix(nums);
        result.forEach(row -> {
            row.forEach(x -> System.out.print(x + "  "));
            System.out.println();
        });
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        // The number of rows we need equals the maximum frequency.
        List<List<Integer>> ans = new ArrayList<>();
        int[] count = new int[nums.length + 1];

        for (final int num : nums) {
            // Construct `ans` on demand.
            if (++count[num] > ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(count[num] - 1).add(num);
        }

        return ans;
    }
}
