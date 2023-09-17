package com.himank.leetcode.problems;

public class Problem847 {

    // https://leetcode.com/problems/shortest-path-visiting-all-nodes/
    public static void main(String[] args) {
        int[][] graph = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        System.out.println("Length of shortest path: " + shortestPathLength(graph));
    }

    private static int[][] cache;

    public static int dp(int node, int mask, int[][] graph) {
        if (cache[node][mask] != 0) {
            return cache[node][mask];
        }
        if ((mask & (mask - 1)) == 0) {
            return 0;
        }

        cache[node][mask] = Integer.MAX_VALUE - 1;
        for (int neighbor : graph[node]) {
            if ((mask & (1 << neighbor)) != 0) {
                int alreadyVisited = dp(neighbor, mask, graph);
                int notVisited = dp(neighbor, mask ^ (1 << node), graph);
                int betterOption = Math.min(alreadyVisited, notVisited);
                cache[node][mask] = Math.min(cache[node][mask], 1 + betterOption);
            }
        }

        return cache[node][mask];
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        cache = new int[n + 1][endingMask + 1];

        int best = Integer.MAX_VALUE;
        for (int node = 0; node < n; node++) {
            best = Math.min(best, dp(node, endingMask, graph));
        }

        return best;
    }
}
