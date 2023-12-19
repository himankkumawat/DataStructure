package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem661 {

    // https://leetcode.com/problems/image-smoother/
    public static void main(String[] args) {
        int[][] image = {{100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}};

        int[][] result = imageSmoother(image);
        Arrays.stream(result).forEach(row -> {
            Arrays.stream(row).forEach(x -> System.out.print(x + "  "));
            System.out.println();
        });
    }

    public static int[][] imageSmoother(int[][] image) {
        // Save the dimensions of the image.
        int m = image.length;
        int n = image[0].length;

        // Iterate over the cells of the image.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize the sum and count
                int sum = 0;
                int count = 0;

                // Iterate over all plausible nine indices.
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        // If the indices form valid neighbor
                        if (0 <= x && x < m && 0 <= y && y < n) {
                            // Extract the original value of img[x][y].
                            sum += image[x][y] % 256;
                            count += 1;
                        }
                    }
                }

                // Encode the smoothed value in img[i][j].
                image[i][j] += (sum / count) * 256;
            }
        }
        // Extract the smoothed value from encoded img[i][j].
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] /= 256;
            }
        }
        // Return the smooth image.
        return image;
    }
}
