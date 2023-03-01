package com.himank.trees;

import static com.himank.trees.CountTotalNodes.buildTree;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubTree {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);

        CountTotalNodes.index = -1;
//        int[] nodes2 = {2, 4, -1, -1, 5, -1, -1};
        int[] nodes2 = {3, -1, 6, -1, -1};
        Node subRoot = buildTree(nodes2);

        System.out.println("Is trees identical? " + isSubTree(root, subRoot));
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (root.data == subRoot.data) {
            if(isIdentical(root, subRoot))
                return true;
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) return true;
        if (root != null && subRoot != null) {
            return root.data == subRoot.data && isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }
}
