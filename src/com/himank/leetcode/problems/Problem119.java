package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem119 {

    // https://leetcode.com/problems/pascals-triangle-ii/
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> result = getRow(rowIndex);
        result.forEach(x -> System.out.print(x + " "));
    }

    public static List<Integer> getRow(int n) {
        List<Integer> row =
                new ArrayList<>() {
                    {
                        add(1);
                    }
                };

        for (int k = 1; k <= n; k++) {
            row.add((int) ((row.get(row.size() - 1) * (long) (n - k + 1)) / k));
        }
        return row;
    }
}
