package com.himank.leetcode.problems;

public class Problem1026 {

    // https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
    public static void main(String[] args) {
        TreeNode root = getTreeNode();
        System.out.println("Maximum difference between node and ancestor: " + maxAncestorDiff(root));
    }

    private static TreeNode getTreeNode() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);

        return root;
    }

    public static int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    // Returns |the maximum - the minimum| of the tree.
    private static int maxAncestorDiff(TreeNode root, int min, int max) {
        if (root == null)
            return 0;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        final int l = maxAncestorDiff(root.left, min, max);
        final int r = maxAncestorDiff(root.right, min, max);
        return Math.max(max - min, Math.max(l, r));
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
