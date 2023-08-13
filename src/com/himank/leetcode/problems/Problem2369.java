package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem2369 {

    // https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 5, 6};
        System.out.println("Is valid partition : " + validPartition(nums));
    }

    private static Map<Integer, Boolean> memo = new HashMap<>();

    private static boolean prefixIsValid(int[] nums, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        boolean ans = false;

        if (i > 0 && nums[i] == nums[i - 1]) {
            ans |= prefixIsValid(nums, i - 2);
        }
        if (i > 1 && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
            ans |= prefixIsValid(nums, i - 3);
        }
        if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1) {
            ans |= prefixIsValid(nums, i - 3);
        }
        memo.put(i, ans);
        return ans;
    }

    public static boolean validPartition(int[] nums) {
        int n = nums.length;
        memo.put(-1, true);

        return prefixIsValid(nums, n - 1);
    }
}
