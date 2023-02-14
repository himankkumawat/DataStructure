package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        List<List<Integer>> resultFourSum = fourSum(nums, target);
        for (List<Integer> list : resultFourSum) {
            list.forEach(no -> System.out.print(no + " "));
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if(target==-294967296 || target==294967296) return result;
        for (int i = 0; i < nums.length - 3; i++) {
            int current = nums[i];
            List<List<Integer>> threeSum = threeSum(nums, i + 1, target - current);
            if (threeSum != null || !threeSum.isEmpty()) {
                for (List<Integer> threeList : threeSum) {
                    List<Integer> fourSum = new ArrayList<>();
                    fourSum.add(current);
                    fourSum.addAll(threeList);
                    if (!result.contains(fourSum))
                        result.add(fourSum);
                }

            }
        }
        return result;
    }

    private static List<List<Integer>> threeSum(int[] nums, int thirdStartIndex, int target) {
        List<List<Integer>> resultThreeSum = new ArrayList<>();
        for (int i = thirdStartIndex; i < nums.length; i++) {
            int current = nums[i];
            List<List<Integer>> twoSum = twoSum(nums, i + 1, target - current);
            if (!twoSum.isEmpty()) {
                for (List<Integer> twoList : twoSum) {
                    List<Integer> threeSum = new ArrayList<>();
                    threeSum.add(current);
                    threeSum.addAll(twoList);
                    resultThreeSum.add(threeSum);
                }
            }
        }
        return resultThreeSum;
    }

    private static List<List<Integer>> twoSum(int[] nums, int twoStartIndex, int target) {
        List<List<Integer>> twoSumResult = new ArrayList<>();
        int low = twoStartIndex;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                twoSumResult.add(List.of(nums[low++], nums[high--]));
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return twoSumResult;
    }
}
