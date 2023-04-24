package com.himank.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1046 {

    // https://leetcode.com/problems/last-stone-weight/
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Stone left with weight : " + lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            if (stone1 != stone2) {
                heap.add(stone1 - stone2);
            }
        }

        return heap.isEmpty() ? 0 : heap.remove();
    }
}
