package com.himank.graph.adjancylist;

import com.himank.graph.matrix.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = insert();

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        int mstCost = 0;

        queue.add(new Pair<>(0, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            if (!visited[current.getKey()]) {
                visited[current.getKey()] = true;
                mstCost += current.getValue();
                for (int i = 0; i < graph[current.getKey()].size(); i++) {
                    Edge edge = graph[current.getKey()].get(i);
                    if (!visited[edge.getDest()])
                        queue.add(new Pair<>(edge.dest, edge.weight));
                }
            }
        }

        System.out.println("Prims algo. MST = " + mstCost);
    }

    private static ArrayList<Edge>[] insert() {
        int vertex = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*
                0
              / |  \
         10 /   |   \ 15
          /     |    \
         1      | 30  2
          \     |    /
         40\    |   / 50
            \   |  /
                3
        */
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));


        return graph;
    }
}
