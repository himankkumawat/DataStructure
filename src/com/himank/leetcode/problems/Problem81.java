package com.himank.leetcode.problems;

public class Problem81 {

    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 5;
        System.out.println("Is target present in array : " + search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }

            boolean pivotArray = existsInFirst(nums, start, nums[mid]);

            boolean targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) {
                if (pivotArray) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    private static boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    private static boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }
}
