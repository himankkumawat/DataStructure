package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem229 {

    // https://leetcode.com/problems/majority-element-ii/description/?envType=daily-question&envId=2023-10-05
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        List<Integer> result = majorityElement(nums);
        result.forEach(System.out::println);
    }

    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int n : nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int n : nums) {
            if (candidate1 != null && n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}
