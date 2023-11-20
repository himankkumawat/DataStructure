package com.himank.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem2391 {

    // https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
    public static void main(String[] args) {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        System.out.println("Minimum time to collect garbage : " + garbageCollection(garbage, travel));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int[] prefixSum = new int[travel.length + 1];
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + travel[i];
        }

        Map<Character, Integer> garbageLastPos = new HashMap<>();

        Map<Character, Integer> garbageCount = new HashMap<>();
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                garbageLastPos.put(c, i);
                garbageCount.put(c, garbageCount.getOrDefault(c, 0) + 1);
            }
        }

        String garbageTypes = "MPG";
        int ans = 0;
        for (char c : garbageTypes.toCharArray()) {
            if (garbageCount.containsKey(c)) {
                ans += prefixSum[garbageLastPos.get(c)] + garbageCount.get(c);
            }
        }

        return ans;
    }
}
