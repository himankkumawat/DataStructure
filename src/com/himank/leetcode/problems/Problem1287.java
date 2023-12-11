package com.himank.leetcode.problems;

public class Problem1287 {

    // https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println("Element repeating more than 25% : " + findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {
        int size = arr.length / 4;
        for (int i = 0; i < arr.length - size; i++) {
            if (arr[i] == arr[i + size]) {
                return arr[i];
            }
        }
        return -1;
    }
}
