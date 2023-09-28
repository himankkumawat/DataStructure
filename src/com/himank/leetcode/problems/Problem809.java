package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem809 {

    // https://leetcode.com/problems/sort-array-by-parity/
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int[] result = sortArrayByParity(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static int[] sortArrayByParity(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, Comparator.comparingInt(a -> a % 2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;
    }
}
