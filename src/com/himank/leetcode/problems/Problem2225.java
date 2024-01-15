package com.himank.leetcode.problems;

import java.util.*;

public class Problem2225 {

    // https://leetcode.com/problems/find-players-with-zero-or-one-losses/
    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> result = findWinners(matches);
        result.forEach(row -> {
            row.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        Map<Integer, Integer> lossesCount = new TreeMap<>();

        for (int[] m : matches) {
            final int winner = m[0];
            final int loser = m[1];
            if (!lossesCount.containsKey(winner))
                lossesCount.put(winner, 0);
            lossesCount.merge(loser, 1, Integer::sum);
        }

        for (final int player : lossesCount.keySet()) {
            final int nLosses = lossesCount.get(player);
            if (nLosses < 2)
                ans.get(nLosses).add(player);
        }

        return ans;
    }
}
