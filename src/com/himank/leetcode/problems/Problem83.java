package com.himank.leetcode.problems;

public class Problem83 {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public static void main(String[] args) {
        ListNode head = getList();
        ListNode result = deleteDuplicates(head);

        printLinkedList(result);
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "   ");
            temp = temp.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    private static ListNode getList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
  }
}
