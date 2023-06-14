package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem530 {

    // https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Minimum absolute difference is : " + getMinimumDifference(root));
    }

    static List<Integer> inorderNodes = new ArrayList<>();

    static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        inorderNodes.add(node.val);
        inorderTraversal(node.right);
    }

    static int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);

        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < inorderNodes.size(); i++) {
            minDifference = Math.min(minDifference, inorderNodes.get(i) - inorderNodes.get(i-1));
        }

        return minDifference;
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
