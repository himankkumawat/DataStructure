package com.himank.leetcode.problems;

public class Problem1802 {

    // https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/
    public static void main(String[] args) {
        System.out.println("Maximum Value at a Given Index in a Bounded Array : " + maxValue(4, 1, 6));
    }

    private static long getSum(int index, int value, int n) {
        long count = 0;
        if (value > index) {
            count += (long) (value + value - index) * (index + 1) / 2;
        } else {
            count += (long) (value + 1) * value / 2 + index - value + 1;
        }
        if (value >= n - index) {
            count += (long) (value + value - n + 1 + index) * (n - index) / 2;
        } else {
            count += (long) (value + 1) * value / 2 + n - index - value;
        }

        return count - value;

    }

    public static int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (getSum(index, mid, n) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
