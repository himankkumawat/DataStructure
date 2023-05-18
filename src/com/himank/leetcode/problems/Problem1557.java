package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1557 {

    // https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
    public static void main(String[] args) {
        List<List<Integer>> graph = getGraph();
        List<Integer> result = findSmallestSetOfVertices(6, graph);
        System.out.println("Nodes required to reach all nodes are : ");
        result.forEach(System.out::println);
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isIncomingEdgeExists = new boolean[n];
        for (List<Integer> edge : edges) {
            isIncomingEdgeExists[edge.get(1)] = true;
        }

        List<Integer> requiredNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isIncomingEdgeExists[i]) {
                requiredNodes.add(i);
            }
        }

        return requiredNodes;
    }

    private static List<List<Integer>> getGraph() {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(0, 1));
        graph.add(List.of(0, 2));
        graph.add(List.of(2, 5));
        graph.add(List.of(3, 4));
        graph.add(List.of(4, 2));
        return graph;
    }
}
