package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem16 {

    // https://leetcode.com/problems/3sum-closest/
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println("Closest sum : " + threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int currentSum = findClosestSum(nums, i, target);
            int currentDiff = Math.abs(currentSum - target);
            if (currentDiff < diff) {
                sum = currentSum;
                diff = currentDiff;
            }
        }
        return sum;
    }

    private static int findClosestSum(int[] nums, int current, int target) {
        int low = current + 1;
        int high = nums.length - 1;
        int closestSum = nums[current] + nums[low] + nums[high];
        int minDiff = closestSum - target;
        while (low < high) {
            int sum = nums[current] + nums[low] + nums[high];
            int diff = sum - target;
            if (Math.abs(diff) < Math.abs(minDiff)) {
                closestSum = sum;
                minDiff = diff;
            }

            if (sum == target) {
                System.out.println("value: " + nums[current] + " " + nums[low] + "  " + nums[high]);
                return closestSum;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return closestSum;
    }
}
