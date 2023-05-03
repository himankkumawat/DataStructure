package com.himank.leetcode.problems;

import java.util.*;

public class Problem2215 {

    // https://leetcode.com/problems/find-the-difference-of-two-arrays/
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2 = {2, 4, 6};

        List<List<Integer>> answer = findDifference(nums1, nums2);

        answer.forEach(System.out::println);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1));
    }

    private static List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> onlyInNums1 = new HashSet<>();

        Set<Integer> existsInNums2 = new HashSet<>();
        for (int num : nums2) {
            existsInNums2.add(num);
        }

        for (int num : nums1) {
            if (!existsInNums2.contains(num)) {
                onlyInNums1.add(num);
            }
        }

        return new ArrayList<>(onlyInNums1);
    }
}
