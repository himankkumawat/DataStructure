package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem1125 {

    // https://leetcode.com/problems/smallest-sufficient-team/description/
    public static void main(String[] args) {
        String[] reqSkills = {"java", "nodejs", "reactjs"};
        List<List<String>> peopleList = new ArrayList<>();
        peopleList.add(List.of("java"));
        peopleList.add(List.of("nodejs"));
        peopleList.add(List.of("nodejs", "reactjs"));
        int[] answer = smallestSufficientTeam(reqSkills, peopleList);
        System.out.println("Smallest sufficient team : ");
        for (int value : answer) {
            System.out.println(value);
        }
    }

    private static int n;
    private static int[] skillsMaskOfPerson;
    private static long[] dp;

    private static Long f(int skillsMask) {
        if (skillsMask == 0) {
            return 0L;
        }
        if (dp[skillsMask] != -1) {
            return dp[skillsMask];
        }
        for (int i = 0; i < n; i++) {
            int smallerSkillsMask = skillsMask & ~skillsMaskOfPerson[i];
            if (smallerSkillsMask != skillsMask) {
                long peopleMask = f(smallerSkillsMask) | (1L << i);
                if (dp[skillsMask] == -1 || Long.bitCount(peopleMask) <
                        Long.bitCount(dp[skillsMask])) {
                    dp[skillsMask] = peopleMask;
                }
            }
        }
        return dp[skillsMask];
    }

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        n = people.size();
        int m = req_skills.length;
        HashMap<String, Integer> skillId = new HashMap<>();
        for (int i = 0; i < m; i++) {
            skillId.put(req_skills[i], i);
        }
        skillsMaskOfPerson = new int[n];
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                skillsMaskOfPerson[i] |= 1 << skillId.get(skill);
            }
        }
        dp = new long[1 << m];
        Arrays.fill(dp, -1);
        long answerMask = f((1 << m) - 1);
        int[] ans = new int[Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }
}
