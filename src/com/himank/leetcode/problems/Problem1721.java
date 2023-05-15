package com.himank.leetcode.problems;

public class Problem1721 {

    // https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
    public static void main(String[] args) {
        ListNode listNode = getHead();
        swapNodes(listNode, 2);
        System.out.println("1st : " + listNode.val);
        System.out.println("2nd : " + listNode.next.val);
        System.out.println("3nd : " + listNode.next.next.val);
        System.out.println("4nd : " + listNode.next.next.next.val);
        System.out.println("5nd : " + listNode.next.next.next.next.val);
    }

    private static ListNode getHead() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        return listNode;
    }

    public static void swapNodes(ListNode head, int k) {
        int listLength = 0;
        ListNode frontNode = null;
        ListNode endNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            listLength++;
            if (endNode != null)
                endNode = endNode.next;
            if (listLength == k) {
                frontNode = currentNode;
                endNode = head;
            }
            currentNode = currentNode.next;
        }
        assert frontNode != null;
        int temp = frontNode.val;
        assert endNode != null;
        frontNode.val = endNode.val;
        endNode.val = temp;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
