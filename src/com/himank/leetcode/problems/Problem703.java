package com.himank.leetcode.problems;

import java.util.PriorityQueue;

public class Problem703 {

    // https://leetcode.com/problems/kth-largest-element-in-a-stream/
    public static void main(String[] args) {
        Problem703 kthLargest = new Problem703(3, new int[]{4, 5, 8, 2});
        assert kthLargest.add(3) == 4;
        assert kthLargest.add(5) == 5;
        assert kthLargest.add(10) == 5;
        assert kthLargest.add(9) == 8;
        assert kthLargest.add(4) == 8;
    }

    private static int k;
    private PriorityQueue<Integer> heap;

    public Problem703(int k, int[] nums) {
        Problem703.k = k;
        heap = new PriorityQueue<>();

        for (int num: nums) {
            heap.offer(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.size() > 0 ? heap.peek() : 0;
    }
}
