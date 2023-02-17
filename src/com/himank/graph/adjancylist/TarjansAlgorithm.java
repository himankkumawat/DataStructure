package com.himank.graph.adjancylist;

import java.util.ArrayList;

public class TarjansAlgorithm {

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = insert();
        boolean[] visited = new boolean[graph.length];
        int[] dt = new int[graph.length];
        int[] low = new int[graph.length];
        int time = 0;

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                tarjansDFS(graph, visited, i, -1, dt, low, time);
            }
        }
    }

    private static void tarjansDFS(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent,
                                   int[] dt, int[] low, int time) {

        visited[current] = true;

        dt[current] = low[current] = ++time;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if (edge.getDest() == parent)
                continue;
            else if (visited[edge.getDest()]) {
                low[current] = Math.min(low[current], dt[edge.getDest()]);
            } else {
                tarjansDFS(graph, visited, edge.getDest(), current, dt, low, time);
                low[current] = Math.min(low[current], low[edge.getDest()]);
                if(dt[current] < low[edge.getDest()]) {
                    System.out.println("Bridge: " + current + " --> " + edge.getDest());
                }
            }
        }

    }

    private static ArrayList<Edge>[] insert() {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[6];

        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        /*

        1 --------- 0 ------------3
        |          /              | \
        |        /                |  \
        |      /                  |   \
        |    /                    |    \
        |  /                      |     \
        | /                       |      \
        2                        4 ------ 5


        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

        return graph;
    }
}
