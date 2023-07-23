package com.himank.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem894 {

    // https://leetcode.com/problems/all-possible-full-binary-trees/
    public static void main(String[] args) {
        int n = 7;
        List<TreeNode> result = allPossibleFBT(n);
        result.forEach(node -> {
            System.out.println("Tree");
            printTree(node);
            System.out.println();
        });
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print(root + " ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        List<List<TreeNode>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(1).add(new TreeNode(0));
        for (int count = 3; count <= n; count += 2) {
            for (int i = 1; i < count - 1; i += 2) {
                int j = count - 1 - i;
                for (TreeNode left : dp.get(i)) {
                    for (TreeNode right : dp.get(j)) {
                        TreeNode root = new TreeNode(0, left, right);
                        dp.get(count).add(root);
                    }
                }
            }
        }

        return dp.get(n);
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
