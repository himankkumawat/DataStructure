package com.himank.leetcode.problems;

import java.util.*;

public class Problem2101 {

    public static void main(String[] args) {
        int[][] bombs = {{1, 2, 3},
                {2, 3, 1},
                {3, 4, 2},
                {4, 5, 3},
                {5, 6, 4}};

        System.out.println("Maximum bombs can be detonated : " + maximumDetonation(bombs));
    }

    public static int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];

                if ((long) ri * ri >= (long) (xi - xj) * (xi - xj) + (long) (yi - yj) * (yi - yj)) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, graph));
        }

        return answer;
    }

    private static int dfs(int i, Map<Integer, List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(i);
        visited.add(i);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int neibour : graph.getOrDefault(cur, new ArrayList<>())) {
                if (!visited.contains(neibour)) {
                    visited.add(neibour);
                    stack.push(neibour);
                }
            }
        }
        return visited.size();
    }
}
