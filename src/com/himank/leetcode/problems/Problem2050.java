package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2050 {

    // https://leetcode.com/problems/parallel-courses-iii/
    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1, 3}, {2, 3}};
        int[] time = {3, 2, 5};
        System.out.println("Minimum number of time to complete all courses: " + minimumTime(n, relations, time));
    }

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int minimumTime(int n, int[][] relations, int[] time) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
        }

        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, dfs(node, time));
        }

        return ans;
    }

    public static int dfs(int node, int[] time) {
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        if (graph.get(node).size() == 0) {
            return time[node];
        }

        int ans = 0;
        for (int neighbor : graph.get(node)) {
            ans = Math.max(ans, dfs(neighbor, time));
        }

        memo.put(node, time[node] + ans);
        return time[node] + ans;
    }
}
