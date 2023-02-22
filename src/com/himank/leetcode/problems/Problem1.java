package com.himank.leetcode.problems;

public class Problem1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;

        System.out.println("Indexes to get sum as " + target + " are: ");
        int[] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return new int[2];
    }
}
