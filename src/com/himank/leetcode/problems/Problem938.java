package com.himank.leetcode.problems;

import com.himank.trees.Node;
import com.himank.trees.bst.BuildBinarySearchTree;

public class Problem938 {

    // https://leetcode.com/problems/range-sum-of-bst/
    public static void main(String[] args) {
        int[] nums = {10, 5, 15, 3, 7, 18};
        Node root = BuildBinarySearchTree.buildBinarySearchTree(nums);
        int low = 7;
        int high = 15;
        System.out.println("Sum of nodes in the range is: " + rangeSumBST(root, low, high));
    }

    public static int rangeSumBST(Node root, int low, int high) {
        if(root == null) return 0;

        if(root.data < low) return rangeSumBST(root.right, low, high);
        if(root.data > high) return rangeSumBST(root.left, low, high);

        return root.data + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
