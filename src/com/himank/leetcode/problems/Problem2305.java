package com.himank.leetcode.problems;

public class Problem2305 {

    // https://leetcode.com/problems/fair-distribution-of-cookies/description/
    public static void main(String[] args) {
        int[] cookies = {8, 15, 10, 20, 8};
        int k = 2;
        System.out.println("Fair distribution of cookies : " + distributeCookies(cookies, k));
    }

    private static int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCount) {
        if (cookies.length - i < zeroCount) {
            return Integer.MAX_VALUE;
        }

        if (i == cookies.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int value : distribute) {
                unfairness = Math.max(unfairness, value);
            }
            return unfairness;
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < k; ++j) {
            zeroCount -= distribute[j] == 0 ? 1 : 0;
            distribute[j] += cookies[i];

            answer = Math.min(answer, dfs(i + 1, distribute, cookies, k, zeroCount));

            distribute[j] -= cookies[i];
            zeroCount += distribute[j] == 0 ? 1 : 0;
        }

        return answer;
    }

    public static int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];

        return dfs(0, distribute, cookies, k, k);
    }
}
