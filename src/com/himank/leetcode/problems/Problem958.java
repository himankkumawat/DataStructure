package com.himank.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem958 {

    // https://leetcode.com/problems/check-completeness-of-a-binary-tree/
    public static void main(String[] args) {
        TreeNode root = getTree();
        System.out.println("Is tree Completed? : " + isCompleteTree(root));
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        boolean nullNodeFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                nullNodeFound = true;
            } else {
                if (nullNodeFound) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

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
