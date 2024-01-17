package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1207 {

    // https://leetcode.com/problems/unique-number-of-occurrences/description/
    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println("Unique number of occurrences: " + uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> occurrences = new HashSet<>();

        for (final int a : arr)
            count.merge(a, 1, Integer::sum);

        for (final int value : count.values())
            if (!occurrences.add(value))
                return false;

        return true;
    }
}
