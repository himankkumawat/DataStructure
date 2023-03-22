package com.himank.leetcode.problems;

import java.util.*;

public class Problem2492 {

    static int answer = Integer.MAX_VALUE;

    // https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
    public static void main(String[] args) {
        int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        int n = 4;
        System.out.println("Minimum score is : " + minScore(n, roads));
    }

    public static void dfs(int node, Map<Integer, List<List<Integer>>> adj, boolean[] visit) {
        visit[node] = true;
        if (!adj.containsKey(node)) {
            return;
        }
        for (List<Integer> edge : adj.get(node)) {
            answer = Math.min(answer, edge.get(1));
            if (!visit[edge.get(0)]) {
                dfs(edge.get(0), adj, visit);
            }
        }
    }

    public static int minScore(int n, int[][] roads) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<>()).add(
                    Arrays.asList(road[1], road[2]));
            adj.computeIfAbsent(road[1], k -> new ArrayList<>()).add(
                    Arrays.asList(road[0], road[2]));
        }

        boolean[] visit = new boolean[n + 1];
        dfs(1, adj, visit);

        return answer;
    }
}
