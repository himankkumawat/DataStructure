package com.himank.leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem1361 {

    // https://leetcode.com/problems/validate-binary-tree-nodes/
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1, -1, 3, -1}, rightChild = {2, -1, -1, -1};
        System.out.println("is tree valid : " + validateBinaryTreeNodes(n, leftChild, rightChild));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        seen.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            int[] children = {leftChild[node], rightChild[node]};

            for (int child : children) {
                if (child != -1) {
                    if (seen.contains(child)) {
                        return false;
                    }

                    queue.add(child);
                    seen.add(child);
                }
            }
        }
        return seen.size() == n;
    }

    public static int findRoot(int n, int[] left, int[] right) {
        Set<Integer> children = new HashSet<>();
        for (int node : left) {
            children.add(node);
        }

        for (int node : right) {
            children.add(node);
        }

        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
