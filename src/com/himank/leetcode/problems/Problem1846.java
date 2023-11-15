package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1846 {

    // https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
    public static void main(String[] args) {
        int[] arr = {2,2,1,2,1};
        System.out.println("Maximum Element After Decreasing and Rearranging " + maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= ans + 1) {
                ans++;
            }
        }

        return ans;
    }
}
