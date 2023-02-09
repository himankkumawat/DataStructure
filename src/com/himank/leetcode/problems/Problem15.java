package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {

    // https://leetcode.com/problems/3sum/
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};

        List<List<Integer>> result = threeSum(nums);
        result.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1])
                checkTwoSum(i, nums, result);
        }

        return result;
    }

    private static void checkTwoSum(int current, int[] nums, List<List<Integer>> result) {
        System.out.println("Current: " + current);
        int low = current + 1;
        int high = nums.length - 1;
        while (high > low) {
            int sum = nums[current] + nums[low] + nums[high];
            if (sum == 0) {
                result.add(List.of(nums[current], nums[low], nums[high]));
                low++;
                high--;
                while (low < nums.length && nums[low] == nums[low - 1]) {
                    low++;
                }
            } else if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
    }
}
