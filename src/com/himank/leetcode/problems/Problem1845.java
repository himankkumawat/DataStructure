package com.himank.leetcode.problems;

import java.util.PriorityQueue;

public class Problem1845 {

    // https://leetcode.com/problems/seat-reservation-manager/
    public static void main(String[] args) {
        Problem1845 seatManager = new Problem1845(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(1);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
    }

    private static PriorityQueue<Integer> availableSeats;

    public Problem1845(int n) {
        availableSeats = new PriorityQueue<>();
        for (int seatNumber = 1; seatNumber <= n; ++seatNumber) {
            availableSeats.offer(seatNumber);
        }
    }

    public int reserve() {
        return availableSeats.poll();
    }

    public void unreserve(int seatNumber) {
        availableSeats.offer(seatNumber);
    }
}
