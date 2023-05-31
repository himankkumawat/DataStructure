package com.himank.leetcode.problems;

public class Problem98 {

    public static void main(String[] args) {
        TreeNode root = getTreeNode();
        System.out.println("Is binary tree valid? : " + isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

    private static TreeNode getTreeNode() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        return root;
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
