package com.himank.graph.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventSafe {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        Map<Integer, List<Integer>> events = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            events.put(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                events.get(i).add(graph[i][j]);
            }
        }

        boolean[] visited = new boolean[graph.length];
        List<Integer> eventSafeNodes = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if(!isEventCyclic(events, visited, i))
                eventSafeNodes.add(i);
        }

        eventSafeNodes.forEach(System.out::println);
    }

    public static boolean isEventCyclic(Map<Integer, List<Integer>> events, boolean[] visited, int current) {

        if (visited[current]) return true;

        List<Integer> destinations = events.get(current);
        if (destinations == null) return false;

        visited[current] = true;
        for (int dest : destinations) {
            if (visited[dest]) {
                return true;
            }
            boolean isNextCyclic = isEventCyclic(events, visited, dest);
            if (isNextCyclic){
                return true;
            }
        }
        visited[current] = false;
        return false;
    }
}
