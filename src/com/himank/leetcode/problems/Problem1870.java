package com.himank.leetcode.problems;

public class Problem1870 {

    // https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/
    public static void main(String[] args) {
        int[] distance = {1, 3, 2};
        double hour = 2.7;
        System.out.println("Minimum speed of train required : " + minSpeedOnTime(distance, hour));
    }

    private static double timeRequired(int[] dist, int speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return time;
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10000000;
        int minSpeed = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (timeRequired(dist, mid) <= hour) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }
}
