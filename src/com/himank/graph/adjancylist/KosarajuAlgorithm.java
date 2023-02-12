package com.himank.graph.adjancylist;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = insert();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];

        // Step 1 : O(V + E)
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i])
                topologicalSort(graph, visited, i, stack);
        }

        System.out.println("*** Topological Sort Stack ***");
        stack.stream().forEach(System.out::println);
        System.out.println();

        // Step 2 : O(V + E)
        ArrayList<Edge>[] transposedGraph = new ArrayList[graph.length];

        for (int i = 0; i < transposedGraph.length; i++) {
            visited[i] = false;
            transposedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); i++) {
                Edge edge = graph[i].get(j);    // src --> dest
                transposedGraph[edge.getDest()].add(new Edge(edge.getDest(), edge.getSrc()));
            }
        }

        // Step 3 : O(V + E)
        System.out.println("*** Strongly Connected Components ***");
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (!visited[current]) {
                kosarajuDFS(transposedGraph, visited, current);
                System.out.println();
            }
        }
    }

    private static void kosarajuDFS(ArrayList<Edge>[] transposedGraph, boolean[] visited, Integer current) {
        visited[current] = true;
        System.out.print(current + "  ");
        for (int i = 0; i < transposedGraph[current].size(); i++) {
            Edge edge = transposedGraph[current].get(i);
            if(!visited[edge.getDest()]) {
                kosarajuDFS(transposedGraph, visited, edge.getDest());
            }
        }
    }

    private static void topologicalSort(ArrayList<Edge>[] graph, boolean[] visited, int current, Stack<Integer> stack) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if (!visited[edge.getDest()])
                topologicalSort(graph, visited, edge.getDest(), stack);
        }
        stack.add(current);
    }

    private static ArrayList<Edge>[] insert() {
        int vertex = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*

         1 ------------> 0 -----------> 3
         /\             /               |
         |            /                 |
         |          /                   |
         |        /                     |
         |      /                       |
         |    /                         |
         |  \/                         \/
          2                            4

        */
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

        return graph;
    }
}
