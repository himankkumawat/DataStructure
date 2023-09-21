package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1136 {

    // https://leetcode.com/problems/parallel-courses/
    public static void main(String[] args) {
        int[][] relation = {{1, 3}, {2, 3}};
        int n = 3;
        System.out.println("Minimum number of semester need to take all courses : " + minimumSemesters(n, relation));
    }

    public static int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
        }
        int[] visited = new int[n + 1];

        int maxLength = 1;
        for (int node = 1; node < n + 1; node++) {
            int length = dfs(node, graph, visited);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    private static int dfs(int node, List<List<Integer>> graph, int[] visited) {
        if (visited[node] != 0) {
            return visited[node];
        } else {
            visited[node] = -1;
        }
        int maxLength = 1;
        for (int endNode : graph.get(node)) {
            int length = dfs(endNode, graph, visited);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length + 1, maxLength);
        }
        visited[node] = maxLength;
        return maxLength;
    }
}
