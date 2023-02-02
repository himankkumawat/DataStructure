package com.himank.graph.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = getGrid2();

        System.out.println("Total number of islands: " + numIslands(grid));
    }

    private static int rows = 0;
    private static int columns = 0;

    public static int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        rows = grid.length;
        columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    bfs(grid, i, j, visited);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private static void bfs(char[][] grid, int currRow, int currColumn, boolean[][] visited) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();
        queue.add(new Pair<>(currRow, currColumn));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int key = pair.getKey();
            int value = pair.getValue();
            for (int[] dir : directions) {
                int rowNeighbour = key + dir[0];
                int columnNeighbour = value + dir[1];
                if (rowNeighbour >= 0 && rowNeighbour < rows
                        && columnNeighbour >= 0 && columnNeighbour < columns
                        && grid[rowNeighbour][columnNeighbour] == '1' && !visited[rowNeighbour][columnNeighbour]) {
                    visited[rowNeighbour][columnNeighbour] = true;
                    queue.add(new Pair<>(rowNeighbour, columnNeighbour));
                }
            }
        }
    }

    private static char[][] getGrid() {
        int n = 4;
        int m = 5;
        char[][] grid = new char[n][m];

        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[0][3] = '1';
        grid[0][4] = '0';

        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '1';
        grid[1][4] = '0';

        grid[2][0] = '1';
        grid[2][1] = '1';
        grid[2][2] = '0';
        grid[2][3] = '0';
        grid[2][4] = '0';

        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '0';
        grid[3][4] = '0';

        return grid;
    }

    private static char[][] getGrid2() {
        int n = 4;
        int m = 5;
        char[][] grid = new char[n][m];

        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';

        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';

        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';

        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';

        return grid;
    }
}
