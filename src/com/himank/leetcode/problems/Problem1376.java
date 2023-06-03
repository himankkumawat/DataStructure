package com.himank.leetcode.problems;

import java.util.ArrayList;

public class Problem1376 {

    public static void main(String[] args) {
        int n = 6, headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 2}, informTime = {0, 0, 1, 0, 0, 0};
        System.out.println("Time taken to inform all employees : " + numOfMinutes(n, headID, manager, informTime));
    }

    private static int maxTime = Integer.MIN_VALUE;

    private static void DFS(ArrayList<ArrayList<Integer>> adjList, int[] informTime, int curr, int time) {
        maxTime = Math.max(maxTime, time);

        for (int adjacent : adjList.get(curr)) {
            DFS(adjList, informTime, adjacent, time + informTime[curr]);
        }
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList.get(manager[i]).add(i);
            }
        }

        DFS(adjList, informTime, headID, 0);
        return maxTime;
    }
}
