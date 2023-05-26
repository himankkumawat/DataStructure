package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem94 {

    public static void main(String[] args) {
        TreeNode treeNode = getTree();
        List<Integer> inorderTraversal = inorderTraversal(treeNode);
        inorderTraversal.forEach(System.out::println);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if(root == null) return inOrder;
        getInOrder(inOrder, root);
        return inOrder;
    }

    private static void getInOrder(List<Integer> inOrder, TreeNode root) {
        if(root == null) return;
        getInOrder(inOrder, root.left);
        inOrder.add(root.val);
        getInOrder(inOrder, root.right);
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
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
