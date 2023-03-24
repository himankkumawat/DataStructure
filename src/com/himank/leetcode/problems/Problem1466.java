package com.himank.leetcode.problems;

import java.util.*;

public class Problem1466 {

    // https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println("Minimum edges to be changed: " + minReorder(n, connections));
    }

    static int count = 0;

    public static void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if (!adj.containsKey(node)) {
            return;
        }
        for (List<Integer> neighbour : adj.get(node)) {
            int child = neighbour.get(0);
            int sign = neighbour.get(1);
            if (child != parent) {
                count += sign;
                dfs(child, node, adj);
            }
        }
    }

    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(
                    Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(
                    Arrays.asList(connection[0], 0));
        }
        dfs(0, -1, adj);
        return count;
    }
}
