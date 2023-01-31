package com.himank.graph.adjancylist;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraph {

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = insert();

        System.out.println("Cyclic exists in graph? " + detectCyclic(graph));
    }

    public static boolean detectCyclic(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && dfsCyclicSearch(graph, visited, i, -1))
                return true;
        }
        return false;
    }

    private static boolean dfsCyclicSearch(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(visited[edge.dest] && edge.dest != parent)
                return true;
            else if(!visited[edge.dest] && dfsCyclicSearch(graph, visited, edge.dest, current))
                return true;
        }
        return false;
    }


    public static ArrayList<Edge>[] insert() {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
            1---------------2
           /|               |
         /  |               |
        0   |               |
         \  |               3
          \ |
           4------------5

        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

        return graph;

    }
}
