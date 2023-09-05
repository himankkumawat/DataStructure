package com.himank.leetcode.problems;

import java.util.HashMap;

public class Problem138 {

    // https://leetcode.com/problems/copy-list-with-random-pointer/
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        Node result = copyRandomList(head);
        while (result != null) {
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }

    private static HashMap<Node, Node> visitedHash = new HashMap<>();

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }

        Node node = new Node(head.val);

        visitedHash.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
