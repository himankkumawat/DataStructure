package com.himank.leetcode.problems;

public class Problem458 {

    // https://leetcode.com/problems/poor-pigs/
    public static void main(String[] args) {
        int buckets = 4, minutesToDie = 15, minutesToTest = 15;
        System.out.println("Minimum number of pigs needed to figure out which bucket is poisonous within the " +
                "allotted time: " + poorPigs(buckets, minutesToDie, minutesToTest));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(states) - 1e-10);
    }
}
