package com.himank.leetcode.problems;

public class Problem86 {

    // https://leetcode.com/problems/partition-list/description/
    public static void main(String[] args) {
        ListNode head = getLinkedList();
        ListNode result = partition(head, 3);
        printLinkedList(result);
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "  ");
            temp = temp.next;
        }
    }

    private static ListNode getLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        return head;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
  }
}
