package com.himank.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

public class Problem1302 {

    // https://leetcode.com/problems/deepest-leaves-sum/
    public static void main(String[] args) {
        TreeNode root = getTree();
        System.out.println("Deepest leaves sum: " + deepestLeavesSum(root));
    }

    public static int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new ArrayDeque<>(Collections.singletonList(root));

        while (!q.isEmpty()) {
            ans = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode node = q.poll();
                assert node != null;
                ans += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return ans;
    }

    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

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
