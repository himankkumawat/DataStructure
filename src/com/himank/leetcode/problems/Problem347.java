package com.himank.leetcode.problems;

import java.util.*;

public class Problem347 {

    // https://leetcode.com/problems/top-k-frequent-elements/
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        Arrays.stream(result).forEach(System.out::println);

    }

    public static int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
