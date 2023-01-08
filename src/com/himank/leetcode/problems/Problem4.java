package com.himank.leetcode.problems;

public class Problem4 {
    public static void main(String[] args) {

        double median = findMedianSortedArrays(getArray1(), getArray2());
        System.out.println("Median is: " + median);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (n2 >= nums2.length || (n1 < nums1.length && nums1[n1] < nums2[n2])) {
                arr[i] = nums1[n1++];
            } else {
                arr[i] = nums2[n2++];
            }
        }

        double median;
        if (arr.length % 2 == 0) {
            median = ((double) arr[(arr.length - 1) / 2] + (double) arr[(arr.length) / 2]) / 2;
        } else {
            median = arr[arr.length / 2];
        }
        return median;
    }

    private static int[] getArray1() {
        int[] arr = {1, 2};
        return arr;
    }

    private static int[] getArray2() {
        int[] arr = {3, 4};
        return arr;
    }
}
