package com.himank.leetcode.problems;

public class Problem1095 {

    // https://leetcode.com/problems/find-in-mountain-array/
    public static void main(String[] args) {
        int target = 3;
        MountainArray mountainArray = new MountainArray();
        System.out.println("Mountain array: " + findInMountainArray(target, mountainArray));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        int low = 1;
        int high = length - 2;
        while (low != high) {
            int testIndex = (low + high) / 2;
            if (mountainArr.get(testIndex) < mountainArr.get(testIndex + 1)) {
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        int peakIndex = low;
        low = 0;
        high = peakIndex;
        while (low != high) {
            int testIndex = (low + high) / 2;
            if (mountainArr.get(testIndex) < target) {
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        if (mountainArr.get(low) == target) {
            return low;
        }
        low = peakIndex + 1;
        high = length - 1;
        while (low != high) {
            int testIndex = (low + high) / 2;
            if (mountainArr.get(testIndex) > target) {
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        if (mountainArr.get(low) == target) {
            return low;
        }
        return -1;
    }

    private static class MountainArray {
        int[] array = {1, 2, 3, 4, 5, 3, 1};

        public int get(int index) {
            return array[index];
        }

        public int length() {
            return array.length;
        }
    }
}
