package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem515 {

    // https://leetcode.com/problems/find-largest-value-in-each-tree-row/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        List<Integer> result = largestValues(root);
        result.forEach(System.out::println);
    }

    private static List<Integer> ans;

    public static List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    public static void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
