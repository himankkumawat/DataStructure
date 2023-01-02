package com.himank.leetcode.problems;

public class Problem26 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2};
        int position = removeDuplicates1(nums);
        for (int i = 0; i < position; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int[] arr = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || arr[index - 1] != nums[i]) {
                arr[index++] = nums[i];
            }
        }
        for (int i = 0; i < index; i++) {
            nums[i] = arr[i];
        }
        return index;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int currentIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[currentIndex++] = nums[i];
        }
        return currentIndex;
    }
}
