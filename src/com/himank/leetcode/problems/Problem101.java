package com.himank.leetcode.problems;

public class Problem101 {

    // https://leetcode.com/problems/symmetric-tree/
    public static void main(String[] args) {
        TreeNode root = getTree();
        System.out.println("Tree is symmetric? : " + isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSubTreesSymmetric(root.left, root.right);
    }

    private static boolean isSubTreesSymmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        return isSubTreesSymmetric(node1.left, node2.right) && isSubTreesSymmetric(node1.right, node2.left);
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        return root;
    }

    private static class TreeNode {
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
