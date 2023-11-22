package com.himank.leetcode.problems;

import com.himank.graph.matrix.Pair;

import java.util.*;

public class Problem1424 {

    // https://leetcode.com/problems/diagonal-traverse-ii/
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3));
        nums.add(Arrays.asList(4, 5, 6));
        nums.add(Arrays.asList(7, 8, 9));

        int[] result = findDiagonalOrder(nums);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0));
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            ans.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new Pair<>(row + 1, col));
            }

            if (col + 1 < nums.get(row).size()) {
                queue.offer(new Pair<>(row, col + 1));
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            result[i] = num;
            i++;
        }

        return result;
    }
}
