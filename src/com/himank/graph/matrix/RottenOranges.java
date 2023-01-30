package com.himank.graph.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {

        int[][] grid = getGrid();

        System.out.println("Total time taken: " + orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int timeTaken = -1;
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int rows = grid.length;
        int column = grid[0].length;
        int freshOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        queue.offer(new Pair<>(-1, -1));
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int key = pair.getKey();
            int value = pair.getValue();
            if (key == -1) {
                timeTaken++;
                if (!queue.isEmpty())
                    queue.offer(new Pair<>(-1, -1));
            } else {
                for (int[] dir : directions) {
                    int rowNeighbour = key + dir[0];
                    int columnNeighbour = value + dir[1];
                    if (rowNeighbour >= 0 && rowNeighbour < rows
                            && columnNeighbour >= 0 && columnNeighbour < column
                            && grid[rowNeighbour][columnNeighbour] == 1) {

                        grid[rowNeighbour][columnNeighbour] = 2;
                        queue.add(new Pair<>(rowNeighbour, columnNeighbour));
                        freshOranges--;
                    }
                }
            }
        }


        return freshOranges == 0 ? timeTaken : -1;
    }

    private static int[][] getGrid() {
        int n = 3;
        int m = 3;
        int[][] grid = new int[n][m];

        grid[0][0] = 2;
        grid[0][1] = 1;
        grid[0][2] = 1;

        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;

        grid[2][0] = 0;
        grid[2][1] = 1;
        grid[2][2] = 1;

        return grid;
    }
}
