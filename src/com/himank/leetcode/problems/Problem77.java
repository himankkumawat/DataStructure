package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {

    // https://leetcode.com/problems/combinations/description/
    public static void main(String[] args) {
        int no = 4, m = 2;
        List<List<Integer>> result = combine(no, m);
        result.forEach(System.out::println);
    }

    private static int n;
    private static int k;

    public static List<List<Integer>> combine(int no, int m) {
        n = no;
        k = m;
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, ans);
        return ans;
    }

    public static void backtrack(List<Integer> curr, int firstNum, List<List<Integer>> ans) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        int need = k - curr.size();
        int remain = n - firstNum + 1;
        int available = remain - need;

        for (int num = firstNum; num <= firstNum + available; num++) {
            curr.add(num);
            backtrack(curr, num + 1, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
