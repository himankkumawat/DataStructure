package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1441 {

    // https://leetcode.com/problems/build-an-array-with-stack-operations/
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        List<String> result = buildArray(target, n);
        result.forEach(System.out::println);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        for (int num : target) {
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }

            ans.add("Push");
            i++;
        }

        return ans;
    }
}
