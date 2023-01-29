package com.himank.graph.adjancylist;

import java.util.ArrayList;

public class AllPathFromSrcToDest {

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = insert2();

        printAllPathsFromSrcToDest(graph, 0, 5);

    }

    public static void printAllPathsFromSrcToDest(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        String path = src + "   ";
        dfsPath(graph, dest, src, visited, path);
    }

    private static void dfsPath(ArrayList<Edge>[] graph, int dest, int current, boolean[] visited, String path) {
        if (current == dest) {
            System.out.println("Path found: " + path);
            return;
        }
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            visited[current] = true;
            if (!visited[edge.dest]) {
                dfsPath(graph, dest, edge.dest, visited, path + edge.dest + "   ");
            }
            visited[current] = false;
        }
    }

    private static void printAllNeighbours(ArrayList<Edge>[] graph, int vertex) {
        if (vertex < 0 || vertex > graph.length - 1) return;

        System.out.println("Vertex neighbours of vertex: " + vertex);
        for (int i = 0; i < graph[vertex].size(); i++) {
            Edge edge = graph[vertex].get(i);
            System.out.println("vertex: " + edge.dest + "      ");
        }
    }

    public static ArrayList<Edge>[] insert1() {
        int vertex = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*      Graph diagram

                0      3
                 \    / \
                  \  /   \
                   2-----1

             */

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        return graph;
    }

    public static ArrayList<Edge>[] insert2() {
        int vertex = 9;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*      Graph diagram

                   1----3
                  /     | \
                0       |  5----6
                 \      | /
                  2----4

                  7-----8

            */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

        graph[7].add(new Edge(7, 8));
        graph[8].add(new Edge(8, 7));

        return graph;
    }
}
