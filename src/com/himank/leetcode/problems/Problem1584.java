package com.himank.leetcode.problems;

public class Problem1584 {

    // https://leetcode.com/problems/min-cost-to-connect-all-points/
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println("Minimum cost to connect each point: " + minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int mstCost = 0;
        int edgesUsed = 0;

        boolean[] inMST = new boolean[n];

        int[] minDist = new int[n];
        minDist[0] = 0;

        for (int i = 1; i < n; ++i) {
            minDist[i] = Integer.MAX_VALUE;
        }

        while (edgesUsed < n) {
            int currMinEdge = Integer.MAX_VALUE;
            int currNode = -1;

            for (int node = 0; node < n; ++node) {
                if (!inMST[node] && currMinEdge > minDist[node]) {
                    currMinEdge = minDist[node];
                    currNode = node;
                }
            }

            mstCost += currMinEdge;
            edgesUsed++;
            inMST[currNode] = true;

            for (int nextNode = 0; nextNode < n; ++nextNode) {
                int weight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                        Math.abs(points[currNode][1] - points[nextNode][1]);

                if (!inMST[nextNode] && minDist[nextNode] > weight) {
                    minDist[nextNode] = weight;
                }
            }
        }

        return mstCost;
    }
}
