package com.himank.trees;

public class CountTotalNodes {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);
        int numberOfNodes = countNumberOfNodes(root);
        System.out.println("Total number of nodes : " + numberOfNodes);
    }

    public static int countNumberOfNodes(Node root) {
        if(root == null) return 0;
        return countNumberOfNodes(root.left) + countNumberOfNodes(root.right) + 1;
    }

    public static int index = -1;

    public static Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) return null;

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }
}
