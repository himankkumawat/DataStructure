package com.himank.trees.bst;

import com.himank.trees.Node;

public class PrintInRange {

    public static void main(String[] args) {
        int[] nums = {8, 5, 10, 3, 6, 11, 1, 4, 14};
        Node root = BuildBinarySearchTree.buildBinarySearchTree(nums);
        BuildBinarySearchTree.printPreOrder(root);
        int lowerRange = 6, highRange = 10;
        System.out.println();
        printByRange(root, lowerRange, highRange);
    }

    public static void printByRange(Node root, int lowRange, int highRange) {
        if (root == null) return;
        if (root.data >= lowRange && root.data <= highRange) {
            printByRange(root.left, lowRange, highRange);
            System.out.print(root.data + "   ");
            printByRange(root.right, lowRange, highRange);
        }
        if (root.data < lowRange) {
            printByRange(root.right, lowRange, highRange);
        }
        if (root.data > highRange)
            printByRange(root.left, lowRange, highRange);
    }
}
