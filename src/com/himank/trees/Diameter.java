package com.himank.trees;

import static com.himank.trees.CountTotalNodes.buildTree;

public class Diameter {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);

        System.out.println("Diameter of tree : " + diameter(root));
        System.out.println("Diameter of tree : " + diameter2(root).diameter);

    }

    // O(n^2)
    public static int diameter(Node root) {
        if (root == null) return 0;
        int diameterLeft = diameter(root.left);
        int diameterRight = diameter(root.right);
        int diameterHeight = HeightOfTree.calculateHeightRecursion(root.left) + HeightOfTree.calculateHeightRecursion(root.right) + 1;

        return Math.max(Math.max(diameterLeft, diameterRight), diameterHeight);
    }

    public static TreeInfo diameter2(Node root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int currentHeight = Math.max(left.height, right.height) + 1;
        int tempDiameter = left.height + right.height + 1;
        int currentDiameter = Math.max(Math.max(left.diameter, right.diameter), tempDiameter);

        return new TreeInfo(currentHeight, currentDiameter);
    }

    public static class TreeInfo {
        int height;
        int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
