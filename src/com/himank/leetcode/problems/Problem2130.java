package com.himank.leetcode.problems;

public class Problem2130 {

    // https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
    public static void main(String[] args) {
        System.out.println("Maximum twin node sum : " + pairSum(getHead()));
    }

    private static ListNode getHead() {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        return listNode;
    }

    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int maximumSum = 0;
        while (prev != null) {
            maximumSum = Math.max(maximumSum, start.val + prev.val);
            prev = prev.next;
            start = start.next;
        }

        return maximumSum;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
