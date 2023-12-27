package com.himank.leetcode.problems;

public class Problem1578 {

    // https://leetcode.com/problems/minimum-time-to-make-rope-colorful
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        System.out.println("Minimum time to make rope colourful : " + minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int maxNeededTime = neededTime[0];

        for (int i = 1; i < colors.length(); ++i) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                ans += Math.min(maxNeededTime, neededTime[i]);
                maxNeededTime = Math.max(maxNeededTime, neededTime[i]);
            } else {
                maxNeededTime = neededTime[i];
            }
        }
        return ans;
    }
}
