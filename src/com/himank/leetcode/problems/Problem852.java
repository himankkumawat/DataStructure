package com.himank.leetcode.problems;

public class Problem852 {

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println("Peak index in the mountain array : " + peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
