package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1356 {

    // https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = sortByBits(arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }


    private static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (Integer.bitCount(a) == Integer.bitCount(b)) {
                return a - b;
            }

            return Integer.bitCount(a) - Integer.bitCount(b);
        }
    }
}
