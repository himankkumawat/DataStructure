package com.himank.graph.matrix;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] grid = getGrid2();

        System.out.println("Can finish courses? " + canFinish(2, grid));
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> courses = new HashMap<>();

        for (int[] relation : prerequisites) {
            if (courses.containsKey(relation[1])) {
                courses.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courses.put(relation[1], nextCourses);
            }
        }

        boolean[] visited = new boolean[numCourses];

        for (int currentCourse = 0; currentCourse < numCourses; currentCourse++) {
            if (isCyclic(currentCourse, courses, visited)) {
                return false;
            }
        }

        return true;
    }


    protected static boolean isCyclic(Integer currentCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] visited) {

        if (visited[currentCourse])
            return true;

        if (!courseDict.containsKey(currentCourse))
            return false;

        visited[currentCourse] = true;

        boolean cycle = false;
        for (Integer nextCourse : courseDict.get(currentCourse)) {
            cycle = isCyclic(nextCourse, courseDict, visited);
            if (cycle)
                break;
        }
        visited[currentCourse] = false;
        return cycle;
    }

    private static int[][] getGrid2() {
        int n = 2;
        int m = 2;
        int[][] grid = new int[n][m];

        grid[0][0] = 1;
        grid[0][1] = 0;

        grid[1][0] = 0;
        grid[1][1] = 1;

        return grid;
    }
}
