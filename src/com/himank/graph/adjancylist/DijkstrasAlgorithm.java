package com.himank.graph.adjancylist;

import com.himank.graph.matrix.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = insert();

        performDijkstra(graph);
    }

    private static void performDijkstra(ArrayList<Edge>[] graph) {
        int source = 0;
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue();
        boolean[] visited = new boolean[graph.length];
        int[] distance = new int[graph.length];
        for (int i = 0; i < distance.length; i++) {
            if (i != source)
                distance[i] = Integer.MAX_VALUE;
        }

        queue.add(new Pair<>(source, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int current = pair.getKey();
            if (!visited[current]) {
                visited[current] = true;

                for (int i = 0; i < graph[current].size(); i++) {
                    Edge edge = graph[current].get(i);
                    int newDistance = distance[current] + edge.weight;
                    if(newDistance < distance[edge.dest]) {
                        distance[edge.dest] = newDistance;
                        queue.add(new Pair<>(edge.dest, distance[edge.dest]));
                    }

                    /*distance[edge.dest] = Math.min(distance[edge.dest], distance[current] + edge.weight);     // This can be replaced with if condition above.
                    queue.add(new Pair<>(edge.dest, distance[edge.dest]));*/
                }

            }
        }

        for (int value : distance) {
            System.out.print(value + "   ");
        }
    }

    private static ArrayList<Edge>[] insert() {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
                       7
                1 -------------> 3
             /\ |               /\  \  1
          2 /   |               |    \
          /     |               |    \/
        0       | 1           2 |     5
          \     |               |    /\
         4 \    |               |    /
           \/  \/               |   /  5
              2----------------> 4
                      3


        */

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        return graph;
    }
}
