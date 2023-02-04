package com.himank.graph.adjancylist;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = insert();

        topologicalSort(graph);
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i])
                topologicalDFS(graph, visited, i, stack);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + "   ");
        }
    }

    private static void topologicalDFS(ArrayList<Edge>[] graph, boolean[] visited, int current, Stack<Integer> recursionStack) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(!visited[edge.dest])
                topologicalDFS(graph, visited, edge.dest, recursionStack);
        }
        recursionStack.push(current);
    }

    private static ArrayList<Edge>[] insert() {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
        5 -------> 0 <--------- 4
        |                       |
        |                       |
        |                       |
        |                       |
       \/                      \/
        2-------> 3 ---------> 1

                */
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));

        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));

        graph[5].add(new Edge(5, 2));

        return graph;
    }


}
