package com.himank.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem733 {

    // https://leetcode.com/problems/flood-fill/
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
//        image = floodFill(image, sr, sc, color);
        floodFill1(image, sr, sc, color);
        for (int[] ints : image) {
            for (int j = 0; j < image[0].length; j++)
                System.out.print(ints[j] + "  ");
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        queue.add(null);
        int initialColor = image[sr][sc];
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] nextEle = queue.poll();
            if (nextEle == null) {
                if (queue.isEmpty())
                    return image;
                queue.add(null);
                continue;
            }
            image[nextEle[0]][nextEle[1]] = color;
            for (int[] dir : direction) {
                int xDir = dir[0] + nextEle[0];
                int yDir = dir[1] + nextEle[1];
                if (xDir < 0 || yDir < 0 || xDir >= image.length || yDir >= image[0].length)
                    continue;
                if (image[xDir][yDir] == initialColor)
                    queue.add(new int[]{xDir, yDir});
            }
        }

        return image;
    }

    public static int[][] floodFill1(int[][] image, int sr, int sc, int color) {

        floodFillRecursive(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void floodFillRecursive(int[][] image, int sr, int sc, int color, int initialColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;

        if (image[sr][sc] != initialColor) {
            return;
        }

        image[sr][sc] = color;
        floodFillRecursive(image, sr + 1, sc, color, initialColor);
        floodFillRecursive(image, sr - 1, sc, color, initialColor);
        floodFillRecursive(image, sr, sc + 1, color, initialColor);
        floodFillRecursive(image, sr, sc - 1, color, initialColor);
    }
}
