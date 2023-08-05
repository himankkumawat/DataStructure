package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {

    // https://leetcode.com/problems/unique-binary-search-trees-ii/description/
    public static void main(String[] args) {
        List<TreeNode> uniqueTrees = generateTrees(3);
        uniqueTrees.forEach(root -> {
            printTree(root);
            System.out.println();
        });
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "  ");
        printTree(root.left);
        printTree(root.right);
    }

    public static List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(null);

        for (int numberOfNodes = 1; numberOfNodes <= n; numberOfNodes++) {
            for (int i = 1; i <= numberOfNodes; i++) {
                int j = numberOfNodes - i;
                for (TreeNode left : dp.get(i - 1)) {
                    for (TreeNode right : dp.get(j)) {
                        TreeNode root = new TreeNode(i, left, clone(right, i));
                        dp.get(numberOfNodes).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }

    private static TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode clonedNode = new TreeNode(node.val + offset);
        clonedNode.left = clone(node.left, offset);
        clonedNode.right = clone(node.right, offset);
        return clonedNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
