package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem1814 {

    // https://leetcode.com/problems/count-nice-pairs-in-an-array/
    public static void main(String[] args) {
        int[] nums = {42, 11, 1, 97};
        System.out.println("Total nice pair in array: " + countNicePairs(nums));
    }

    public static int countNicePairs(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> dic = new HashMap<>();
        int ans = 0;
        int MOD = (int) 1e9 + 7;
        for (int num : arr) {
            ans = (ans + dic.getOrDefault(num, 0)) % MOD;
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }

        return ans;
    }

    public static int rev(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }
}
