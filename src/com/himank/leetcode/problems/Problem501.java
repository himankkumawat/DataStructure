package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem501 {

    // https://leetcode.com/problems/find-mode-in-binary-search-tree/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] result = findMode(root);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] findMode(TreeNode root) {
        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode friend = curr.left;
                while (friend.right != null) {
                    friend = friend.right;
                }

                friend.right = curr;
                TreeNode left = curr.left;
                curr.left = null;
                curr = left;
            } else {
                int num = curr.val;
                if (num == currNum) {
                    currStreak++;
                } else {
                    currStreak = 1;
                    currNum = num;
                }

                if (currStreak > maxStreak) {
                    ans = new ArrayList<>();
                    maxStreak = currStreak;
                }

                if (currStreak == maxStreak) {
                    ans.add(num);
                }

                curr = curr.right;
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
