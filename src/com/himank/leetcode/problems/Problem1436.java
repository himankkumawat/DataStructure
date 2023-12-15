package com.himank.leetcode.problems;

import java.util.*;

public class Problem1436 {

    // https://leetcode.com/problems/destination-city/
    public static void main(String[] args) {
        List<String> path1 = Arrays.asList("London", "New York");
        List<String> path2 = Arrays.asList("New York", "Lima");
        List<String> path3 = Arrays.asList("Lima", "Sao Paulo");
        List<List<String>> paths = new ArrayList<>();
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);

        System.out.println("Destination city: " + destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> hasOutgoing = new HashSet<>();
        for (List<String> path : paths) {
            hasOutgoing.add(path.get(0));
        }
        for (List<String> path : paths) {
            String candidate = path.get(1);
            if (!hasOutgoing.contains(candidate)) {
                return candidate;
            }
        }
        return "";
    }
}
