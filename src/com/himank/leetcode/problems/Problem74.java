package com.himank.leetcode.problems;

public class Problem74 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        int target = 16;

        System.out.println("Target exists? : " + searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] arr = matrix[mid];
            if (target < arr[0]) {
                high = mid - 1;
            } else if (target > arr[arr.length - 1]) {
                low = mid + 1;
            } else {
                return findElement(arr, target);
            }
        }
        return false;
    }

    private static boolean findElement(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
