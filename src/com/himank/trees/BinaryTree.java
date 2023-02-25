package com.himank.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);
        System.out.println("Root: " + root.data);
        preOrderPrint(root);
        System.out.println();
        inOrderPrint(root);
        System.out.println();
        postOrderPrint(root);
        System.out.println();
        System.out.println("***** Level Order *****");
        levelOrderPrint(root);
    }

    public static void preOrderPrint(Node root) {
        if (root == null) return;
        System.out.print(root.data + "  ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public static void inOrderPrint(Node root) {
        if (root == null) return;
        inOrderPrint(root.left);
        System.out.print(root.data + "  ");
        inOrderPrint(root.right);
    }

    public static void postOrderPrint(Node root) {
        if (root == null) return;
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.data + "  ");
    }

    public static void levelOrderPrint(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                System.out.println();
                if (queue.isEmpty()) break;
                else queue.add(null);
                continue;
            }
            System.out.print(current.data + "  ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

        }
    }

    private static int index = -1;

    public static Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) return null;

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
}

