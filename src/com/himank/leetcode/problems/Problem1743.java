package com.himank.leetcode.problems;

import java.util.*;

public class Problem1743 {

    // https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
    public static void main(String[] args) {
        int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
        int[] result = restoreArray(adjacentPairs);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static int[] restoreArray(int[][] adjacentPairs) {
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];

            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }

            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int root = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int[] ans = new int[graph.size()];
        dfs(root, Integer.MAX_VALUE, ans, 0);
        return ans;
    }

    private static void dfs(int node, int prev, int[] ans, int i) {
        ans[i] = node;
        for (int neighbor : graph.get(node)) {
            if (neighbor != prev) {
                dfs(neighbor, node, ans, i + 1);
            }
        }
    }
}
