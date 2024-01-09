package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem872 {

    // https://leetcode.com/problems/leaf-similar-trees/
    public static void main(String[] args) {
        TreeNode root1 = getTree1();
        TreeNode root2 = getTree2();
        System.out.println("Similar leaf tree:" + leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void dfs(TreeNode node, List<Integer> leaves) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }

    private static TreeNode getTree1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);

        return root;
    }

    private static TreeNode getTree2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(8);

        return root;
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
    }
}
