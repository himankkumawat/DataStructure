package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1887 {

    // https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal
    public static void main(String[] args) {
        int[] arr = {5, 1, 3};
        System.out.println("Reduction Operations to Make the Array Elements Equal : " + reductionOperations(arr));
    }

    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int up = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                up++;
            }
            ans += up;
        }
        return ans;
    }
}
