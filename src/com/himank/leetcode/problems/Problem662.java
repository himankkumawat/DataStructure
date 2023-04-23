package com.himank.leetcode.problems;

import com.himank.graph.matrix.Pair;

import java.util.LinkedList;

public class Problem662 {

    // https://leetcode.com/problems/maximum-width-of-binary-tree/
    public static void main(String[] args) {
        TreeNode root = getTree();

        System.out.println("Maximum width is : " + widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int maxWidth = 0;

        queue.addLast(new Pair<>(root, 0));
        while (queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();

            int currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;
            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                if (node.left != null)
                    queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                if (node.right != null)
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
            }

            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }

        return maxWidth;
    }


    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        return root;
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
    }
}
