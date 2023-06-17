package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {

    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);
        result.forEach(System.out::println);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> inOrders = new ArrayList<>();
        if (root == null) return inOrders;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> levelNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (null == currentNode) {
                inOrders.add(levelNodes);
                levelNodes = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                levelNodes.add(currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return inOrders;
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
