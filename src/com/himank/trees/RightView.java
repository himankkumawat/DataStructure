package com.himank.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.himank.trees.CountTotalNodes.buildTree;

public class RightView {

    public static void main(String[] args) {
        int[] nodes = {1, 2, -1, 5, -1, -1, 3, -1, 4, -1, -1};
        Node root = buildTree(nodes);
        List<Integer> result = rightSideView(root);
        result.forEach(System.out::println);
    }

    public static List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode == null) {
                if (!queue.isEmpty())
                    queue.add(null);
            } else {
                if(null != currentNode.left) queue.add(currentNode.left);
                if(null != currentNode.right) queue.add(currentNode.right);
                if (!queue.isEmpty() && queue.peek() == null) {
                    result.add(currentNode.data);
                }
            }
        }

        return result;
    }
}
