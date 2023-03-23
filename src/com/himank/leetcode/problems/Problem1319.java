package com.himank.leetcode.problems;

import java.util.ArrayList;

public class Problem1319 {

    // https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int changes = makeConnected(6, connections);
        System.out.println("Number of connection changed = " + changes);
    }


    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            ArrayList<Edge> edgeList = graph[connection[0]];
            edgeList.add(new Edge(connection[0], connection[1]));
            graph[connection[0]] = edgeList;

            edgeList = graph[connection[1]];
            edgeList.add(new Edge(connection[1], connection[0]));
            graph[connection[1]] = edgeList;
        }
        int numberOfConnections = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numberOfConnections++;
                dfs(graph, i, visited);
            }
        }
        return numberOfConnections - 1;
    }

    private static void dfs(ArrayList<Edge>[] graph, int current, boolean[] visited) {
        if (visited[current]) return;
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            dfs(graph, edge.dest, visited);
        }
    }

    public static class Edge {
        int source;
        int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
}
