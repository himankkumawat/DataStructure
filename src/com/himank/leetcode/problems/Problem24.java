package com.himank.leetcode.problems;

public class Problem24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode reverse = swapPairs(head);
        System.out.println("New head : " + reverse.val);
    }


    public static ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        if(head != null && head.next != null) {
            head = head.next;
        }
        ListNode prev = null;
        ListNode exch;
        ListNode nextPair;
        while(temp != null && temp.next != null) {
            exch = temp.next;
            nextPair = exch.next;
            exch.next = temp;
            temp.next = nextPair;
            if(prev != null)
                prev.next = exch;
            prev = temp;
            temp = nextPair;
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
