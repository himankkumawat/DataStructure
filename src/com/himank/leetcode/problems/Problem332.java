package com.himank.leetcode.problems;

import java.util.*;

public class Problem332 {

    // https://leetcode.com/problems/reconstruct-itinerary/
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("MUC", "LHR"));
        tickets.add(List.of("JFK", "MUC"));
        tickets.add(List.of("SFO", "SJC"));
        tickets.add(List.of("LHR", "SFO"));
        findItinerary(tickets);
        result.forEach(System.out::println);
    }

    private static HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    private static LinkedList<String> result = null;

    public static void findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (flightMap.containsKey(origin)) {
                LinkedList<String> destList = flightMap.get(origin);
                destList.add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<>();
                destList.add(dest);
                flightMap.put(origin, destList);
            }
        }
        flightMap.forEach((key, value) -> Collections.sort(value));

        result = new LinkedList<>();
        DFS("JFK");
    }

    protected static void DFS(String origin) {
        if (flightMap.containsKey(origin)) {
            LinkedList<String> destList = flightMap.get(origin);
            while (!destList.isEmpty()) {
                String dest = destList.pollFirst();
                DFS(dest);
            }
        }
        result.offerFirst(origin);
    }
}
