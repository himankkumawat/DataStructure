package com.himank.leetcode.problems;

import java.util.*;

public class Problemm815 {

    public static void main(String[] args) {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int source = 1, target = 6;
        System.out.println("Least number of bus required: " + numBusesToDestination(routes, source, target));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int r = 0; r < routes.length; r++) {
            for (int stop : routes[r]) {
                ArrayList<Integer> route = adjList.getOrDefault(stop, new ArrayList<>());
                route.add(r);
                adjList.put(stop, route);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>(routes.length);
        for (int route : adjList.get(source)) {
            q.add(route);
            vis.add(route);
        }

        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int route = q.remove();

                for (int stop : routes[route]) {
                    if (stop == target) {
                        return busCount;
                    }

                    for (int nextRoute : adjList.get(stop)) {
                        if (!vis.contains(nextRoute)) {
                            vis.add(nextRoute);
                            q.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}
