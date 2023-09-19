package com.himank.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Problem287 {

    // https://leetcode.com/problems/find-the-duplicate-number/
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int result = findDuplicate(nums);
        System.out.println("Duplicate number is : " + result);
    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}
