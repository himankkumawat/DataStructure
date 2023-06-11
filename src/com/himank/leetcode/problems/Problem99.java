package com.himank.leetcode.problems;

public class Problem99 {

    // https://leetcode.com/problems/recover-binary-search-tree/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        recoverTree(root);

        System.out.println("New tree root : " + root.val);
    }

    static TreeNode x = null, y = null, pred = null;

    public static void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public static void findTwoSwapped(TreeNode root) {
        if (root == null) return;
        findTwoSwapped(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) x = pred;
            else return;
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    public static void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
