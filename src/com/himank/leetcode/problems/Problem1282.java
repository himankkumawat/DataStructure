package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1282 {

    // https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
    public static void main(String[] args) {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = groupThePeople(groupSizes);
        result.forEach(group -> {
            group.forEach(x -> System.out.print(x + "  "));
            System.out.println();
        });
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> szToGroup = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!szToGroup.containsKey(groupSizes[i])) {
                szToGroup.put(groupSizes[i], new ArrayList<>());
            }

            List<Integer> group = szToGroup.get(groupSizes[i]);
            group.add(i);
            if (group.size() == groupSizes[i]) {
                ans.add(group);
                szToGroup.remove(groupSizes[i]);
            }
        }

        return ans;
    }
}
