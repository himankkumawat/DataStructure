package com.himank.trees.bst;

import com.himank.trees.Node;

public class BuildBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 4, 2, 7};
        Node root = buildBinarySearchTree(nums);
        printPreOrder(root);
        System.out.println();
        System.out.println("Search 6 in BST: " + searchInBst(root, 6));
        root = delete(root, 5);
        System.out.println("After deletion: " + 5);
        printPreOrder(root);
    }

    public static Node delete(Node root, int data) {
        if (root == null) return null;
        if (root.data > data)
            root.left = delete(root.left, data);
        else if (root.data < data)
            root.right = delete(root.right, data);
        else {
            if (root.left == null && root.right == null) {              // Case 1
                return null;
            } else if (root.left != null && root.right == null) {       // Case 2
                return root.left;
            } else if (root.left == null) {                             // Case2
                return root.right;
            } else {                                                    // Case 3
                Node inOrderSuccessor = getInOrderSuccessor(root);
                root.data = inOrderSuccessor.data;
                root.right = delete(root.right, root.data);
            }

        }
        return root;
    }

    private static Node getInOrderSuccessor(Node root) {
        if (root == null) return null;
        Node temp = root.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public static Node buildBinarySearchTree(int[] nums) {
        if (nums.length == 0) return null;
        Node root = null;
        for (int num : nums) {
            root = insert(root, num);
        }
        return root;
    }

    private static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (root.data > data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    public static void printPreOrder(Node root) {
        if (root == null) return;
        printPreOrder(root.left);
        System.out.print(root.data + "  ");
        printPreOrder(root.right);
    }

    public static boolean searchInBst(Node root, int data) {
        if (root == null) return false;
        if (root.data == data)
            return true;
        else if (root.data > data)
            return searchInBst(root.left, data);
        else
            return searchInBst(root.right, data);
    }
}
