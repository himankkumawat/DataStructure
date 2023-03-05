package com.himank.trees;

import static com.himank.trees.CountTotalNodes.buildTree;

public class UniValueSubTree {
    public static void main(String[] args) {
//        int[] nodes = {5, 1, 5, 5, 5, -1, 5};
        int[] nodes = {5, 5, 1};
        Node root = buildTree(nodes);

        System.out.println("Total UniValue subtree = " + countUnivalSubtrees(root));
    }

    public static int countUnivalSubtrees(Node root) {
        return countUniValueSubTrees(root.left, root.data) + countUniValueSubTrees(root.right, root.data);
    }

    private static int countUniValueSubTrees(Node root, int value) {
        if (root == null) return 0;
        boolean isRootSame = root.data == value;
        return countUniValueSubTrees(root.left, value) + countUniValueSubTrees(root.right, value) + (isRootSame ? 1 : 0);
    }
}
