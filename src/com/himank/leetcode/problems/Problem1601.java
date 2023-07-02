package com.himank.leetcode.problems;

public class Problem1601 {

    // https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/description/
    public static void main(String[] args) {
        int[][] requests = {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        int n = 5;
        System.out.println("Maximum Number of Achievable Transfer Requests : " + maximumRequests(n, requests));
    }

    private static int answer = 0;

    private static void maxRequest(int[][] requests, int[] indegree, int n, int index, int count) {
        if (index == requests.length) {
            for (int i = 0; i < n; i++) {
                if (indegree[i] != 0) {
                    return;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        indegree[requests[index][0]]--;
        indegree[requests[index][1]]++;
        maxRequest(requests, indegree, n, index + 1, count + 1);
        indegree[requests[index][0]]++;
        indegree[requests[index][1]]--;

        maxRequest(requests, indegree, n, index + 1, count);
    }

    public static int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        maxRequest(requests, indegree, n, 0, 0);

        return answer;
    }
}
