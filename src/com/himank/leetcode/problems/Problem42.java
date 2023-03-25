package com.himank.leetcode.problems;

public class Problem42 {

    // https://leetcode.com/problems/trapping-rain-water/
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total rain water trap is : " + trap(height));
    }

    public static int trap(int[] height) {
        int output = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i]);
        }

        for (int i = 0; i < n; i++) {
            int currentTrappedWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            currentTrappedWater = Math.max(currentTrappedWater, 0);
            output += currentTrappedWater;
        }
        return output;
    }
}
