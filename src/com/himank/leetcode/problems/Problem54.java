package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {

    static List<Integer> answer;

    // https://leetcode.com/problems/spiral-matrix/
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        List<Integer> ans = spiralOrder(matrix);

        ans.forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        answer = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        getElements(matrix, 0, 0, 'r', visited);
        return answer;
    }

    private static void getElements(int[][] matrix, int i, int j, char dir, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return;
        if (visited[i][j]) return;

        answer.add(matrix[i][j]);
        visited[i][j] = true;

        if (dir == 'u') {
            getElements(matrix, i - 1, j, 'u', visited);
        }
        getElements(matrix, i, j + 1, 'r', visited);
        getElements(matrix, i + 1, j, 'd', visited);
        getElements(matrix, i, j - 1, 'l', visited);
        getElements(matrix, i - 1, j, 'u', visited);
    }
}
