package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;

public class Problem2009 {

    // https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6};
        System.out.println("Minimum number of operations to make array continuous : " + minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int[] newNums = new int[unique.size()];
        int index = 0;
        for (int num : unique) {
            newNums[index++] = num;
        }
        Arrays.sort(newNums);
        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            while (j < newNums.length && newNums[j] < newNums[i] + n) {
                j++;
            }
            int count = j - i;
            ans = Math.min(ans, n - count);
        }
        return ans;
    }
}
