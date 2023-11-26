package com.himank.leetcode.problems;

import com.himank.graph.matrix.Pair;

import java.util.ArrayList;
import java.util.List;

public class Problem1727 {

    // https://leetcode.com/problems/largest-submatrix-with-rearrangements/
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println("Largest submatrix with rearrangement: " + largestSubmatrix(matrix));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer,Integer>> prevHeights = new ArrayList<>();
        int ans = 0;

        for (int[] ints : matrix) {
            List<Pair<Integer, Integer>> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];

            for (Pair<Integer, Integer> pair : prevHeights) {
                int height = pair.getKey();
                int col = pair.getValue();
                if (ints[col] == 1) {
                    heights.add(new Pair<>(height + 1, col));
                    seen[col] = true;
                }
            }

            for (int col = 0; col < n; col++) {
                if (!seen[col] && ints[col] == 1) {
                    heights.add(new Pair<>(1, col));
                }
            }

            for (int i = 0; i < heights.size(); i++) {
                ans = Math.max(ans, heights.get(i).getKey() * (i + 1));
            }

            prevHeights = heights;
        }

        return ans;
    }
}
