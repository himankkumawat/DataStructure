package com.himank.trees;

import java.util.LinkedList;
import java.util.Queue;

import static com.himank.trees.CountTotalNodes.buildTree;

public class HeightOfTree {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);
        int height = calculateHeight(root);
        System.out.println("height of the tree is : " + height);
        height = calculateHeightRecursion(root);
        System.out.println("height of the tree is : " + height);
    }

    public static int calculateHeightRecursion(Node root) {
        if(root == null) return 0;
        return Math.max(calculateHeightRecursion(root.left), calculateHeightRecursion(root.right)) + 1;
    }

    public static int calculateHeight(Node root) {
        int height = 0;
        if(root == null) return height;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current == null) {
                height++;
                if(!queue.isEmpty()) queue.add(null);
                continue;
            }
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return height;
    }
}
