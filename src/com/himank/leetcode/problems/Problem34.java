package com.himank.leetcode.problems;

public class Problem34 {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] range = searchRange(nums, target);
        System.out.println("Lower index: " + range[0]);
        System.out.println("Higher index: " + range[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int index = searchElement(nums, target);
        if(index == -1) return new int[] {-1, -1};
        int low = index;
        int high = index;
        while(low > 0 && high < nums.length-1 && nums[low-1] == target && nums[high+1] == target) {
            low--;
            high++;
        }
        while(low > 0 && nums[low - 1] == target)
            low--;
        while(high < nums.length-1 && nums[high+1] == target)
            high++;

        return new int[]{low, high};
    }

    private static int searchElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
