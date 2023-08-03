package com.himank.leetcode.problems;

public class Problem61 {

    // https://leetcode.com/problems/rotate-list/
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode rotatedList = rotateRight(head, 3);

        System.out.println("Rotated List... ");
        while (rotatedList != null) {
            System.out.println(rotatedList.val);
            rotatedList = rotatedList.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null || k == 0) return head;
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            length++;
        }
        k = k % length;
        if(k == 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(k-->0) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        temp = slow.next;
        slow.next = fast.next;
        fast.next = head;
        head = temp;

        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
  }
}
