package com.himank.leetcode.problems;

import com.himank.graph.matrix.Pair;

public class Problem2265 {

    // https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println("Count of nodes average of subtree : " + averageOfSubtree(root));

    }

    private static int count = 0;

    private static Pair<Integer, Integer> postOrder(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> left = postOrder(root.left);
        Pair<Integer, Integer> right = postOrder(root.right);

        int nodeSum = left.getKey() + right.getKey() + root.val;
        int nodeCount = left.getValue() + right.getValue() + 1;

        if (root.val == nodeSum / (nodeCount)) {
            count++;
        }

        return new Pair<>(nodeSum, nodeCount);
    }

    public static int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
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
