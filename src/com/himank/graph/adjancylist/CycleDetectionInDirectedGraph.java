package com.himank.graph.adjancylist;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = insert();

        boolean isCycleExists = dfsCycleDefect(graph);

        System.out.println("Cycle exists in graph? " + isCycleExists);
    }

    private static boolean dfsCycleDefect(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean isCycleExists = false;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                isCycleExists = isCycleExists(graph, i, visited, new boolean[graph.length]);
                if (isCycleExists)
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycleExists(ArrayList<Edge>[] graph, int current, boolean[] visited, boolean[] recursionStack) {
        visited[current] = true;
        recursionStack[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(recursionStack[edge.dest])
                return true;
            else if(!visited[edge.dest]) {
                if(isCycleExists(graph, edge.dest, visited, recursionStack)) {
                    return true;
                }
            }
        }
        recursionStack[current] = false;
        return false;
    }


    public static ArrayList<Edge>[] insert() {
        int vertex = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*      Graph diagram

            1------> 0 <---3
                    |     /\
                    |     /
                    |   /
                   \/ /
                   2
             */

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        return graph;
    }
}
