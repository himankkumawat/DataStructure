package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1980 {

    // https://leetcode.com/problems/find-unique-binary-string/
    public static void main(String[] args) {
        String[] nums = {"111", "011", "001"};
        System.out.println("Unique binary string is : " + findDifferentBinaryString(nums));
    }

    private static int n;
    private static Set<String> numsSet = new HashSet<>();

    private static String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0");
        if (addZero.length() > 0) {
            return addZero;
        }

        return generate(curr + "1");
    }

    public static String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        numsSet.addAll(Arrays.asList(nums));

        return generate("");
    }
}
