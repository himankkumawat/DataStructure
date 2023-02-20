package com.himank.leetcode.problems;

public class Problem11 {

    // https://leetcode.com/problems/container-with-most-water/
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Container with maximum water : " + maxArea(height));
    }

    public static int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int ht = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, ht * (right - left));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;

    }
}
