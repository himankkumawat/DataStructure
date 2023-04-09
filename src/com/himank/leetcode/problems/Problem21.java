package com.himank.leetcode.problems;

public class Problem21 {

    // https://leetcode.com/problems/merge-two-sorted-lists/
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(head1, head2);
        System.out.println("Merged List head : " + result.val);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode last = null;
        while(list1 != null || list2 != null) {
            if((list1 != null && list2 != null && list1.val < list2.val) || (list2 == null)) {
                if(head == null) {
                    head = new ListNode(list1.val);
                    last = head;
                } else {
                    ListNode newNode = new ListNode(list1.val);
                    last.next = newNode;
                    last = newNode;
                }
                list1 = list1.next;
            } else {
                if(head == null) {
                    head = new ListNode(list2.val);
                    last = head;
                } else {
                    ListNode newNode = new ListNode(list2.val);
                    last.next = newNode;
                    last = newNode;
                }
                list2 = list2.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
