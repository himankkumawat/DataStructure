package com.himank.leetcode.problems;

import com.himank.graph.matrix.Pair;

import java.util.*;

public class Problem2385 {

    // https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
    public static void main(String[] args) {
        TreeNode root = getTree();
        System.out.println("Amount of Time for Binary Tree to Be Infected : " + amountOfTime(root, 3));
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        return root;
    }

    public static int amountOfTime(TreeNode root, int start) {
        int ans = -1;
        Map<Integer, List<Integer>> graph = getGraph(root);
        Queue<Integer> q = new ArrayDeque<>(Collections.singletonList(start));
        Set<Integer> seen = new HashSet<>(Collections.singletonList(start));

        for (; !q.isEmpty(); ++ans) {
            for (int sz = q.size(); sz > 0; --sz) {
                final int u = q.poll();
                if (!graph.containsKey(u))
                    continue;
                for (final int v : graph.get(u)) {
                    if (seen.contains(v))
                        continue;
                    q.offer(v);
                    seen.add(v);
                }
            }
        }

        return ans;
    }

    private static Map<Integer, List<Integer>> getGraph(TreeNode root) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // (node, parent)
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>(Collections.singletonList(new Pair<>(root, -1)));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            final int parent = pair.getValue();
            if (parent != -1) {
                graph.putIfAbsent(parent, new ArrayList<>());
                graph.putIfAbsent(node.val, new ArrayList<>());
                graph.get(parent).add(node.val);
                graph.get(node.val).add(parent);
            }
            if (node.left != null)
                q.add(new Pair<>(node.left, node.val));
            if (node.right != null)
                q.add(new Pair<>(node.right, node.val));
        }

        return graph;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
