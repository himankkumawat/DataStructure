package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1502 {

    // https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
    public static void main(String[] args) {
        int[] arr = {3, 5, 1};
        System.out.println("Can array make AP : " + canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if ((arr[i] - arr[i - 1]) != diff)
                return false;
        }
        return true;
    }
}
