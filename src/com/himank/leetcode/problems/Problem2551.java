package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem2551 {

    // https://leetcode.com/problems/put-marbles-in-bags/description/
    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        System.out.println("Difference b/w max and min scores among marble distribution : " + putMarbles(weights, k));
    }

    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairWeights, 0, n - 1);

        long answer = 0L;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
}
