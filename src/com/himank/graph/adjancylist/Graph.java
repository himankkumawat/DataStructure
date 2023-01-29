package com.himank.graph.adjancylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = insert2();

        int showNeighboursTo = 2;
        printAllNeighbours(graph, showNeighboursTo);

        System.out.println("BFS Traversal...");
        bfs(graph);
        System.out.println();

        System.out.println("DFS Traversal...");
        dfs(graph);
        System.out.println();
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
//                System.out.println("************************** DFS Print with recursive **************************");
//                dfsPrint(graph, i, visited);
//                System.out.println();

                System.out.println("************************** DFS Print with recursive **************************");
                dfsPrintRecursive(graph, i, visited);
            }
        }
    }

    private static void dfsPrint(ArrayList<Edge>[] graph, int current, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(current);
        while (!stack.empty()) {
            current = stack.pop();
            if (!visited[current]) {
                System.out.println("DFS print: " + current);
                visited[current] = true;
                for (int i = 0; i < graph[current].size(); i++) {
                    Edge edge = graph[current].get(i);
                    stack.push(edge.dest);
                }
            }
        }
    }

    private static void dfsPrintRecursive(ArrayList<Edge>[] graph, int current, boolean[] visited) {
        System.out.println("BFS recursive print: " + current);
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if (!visited[edge.dest])
                dfsPrintRecursive(graph, edge.dest, visited);
        }
    }


    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsPrint(graph, i, visited);
            }
        }
    }

    private static void bfsPrint(ArrayList<Edge>[] graph, int source, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (!visited[current]) {
                System.out.println("BFS print: " + current);
                visited[current] = true;
                for (int i = 0; i < graph[current].size(); i++) {
                    queue.add(graph[current].get(i).dest);
                }
            }
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
