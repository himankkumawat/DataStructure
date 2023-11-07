package com.himank.leetcode.problems;

import java.util.Arrays;

public class Problem1921 {

    // https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
    public static void main(String[] args) {
        int[] dist = {1, 3, 4}, speed = {1, 1, 1};
        System.out.println("Max number of monster which can be eliminated: " + eliminateMaximum(dist, speed));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        double[] arrival = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrival[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(arrival);
        int ans = 0;
        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] <= i) {
                break;
            }
            ans++;
        }
        return ans;
    }
}
