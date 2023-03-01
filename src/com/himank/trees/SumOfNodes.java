package com.himank.trees;

import static com.himank.trees.CountTotalNodes.buildTree;

public class SumOfNodes {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);
        int sum = sumOfNodes(root);
        System.out.println("Total sum of nodes in tree : " + sum);
    }

    public static int sumOfNodes(Node root) {
        if(root == null) return 0;
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }
}
