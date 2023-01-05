package com.himank.leetcode.problems;

public class Problem2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Problem2 prob = new Problem2();
        ListNode head1 = prob.getListNode1();
        ListNode head2 = prob.getListNode2();

        prob.printListNode(head1);
        prob.printListNode(head2);

        ListNode answer = prob.addTwoNumbers(head1, head2);
        prob.printListNode(answer);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = null;

        int sum;
        int carry = 0;

        while (temp1 != null && temp2 != null) {
            sum = temp1.val + temp2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            if(head == null) {
                temp = new ListNode(sum);
                head = temp;

            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1 = temp1 == null ? temp2 : temp1;
        while (temp1 != null) {
            sum = temp1.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;
            temp1 = temp1.next;
        }

        if(carry > 0) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }

        return head;
    }

    private ListNode getListNode1() {
        ListNode head = new ListNode(3);
        head = new ListNode(4, head);
        head = new ListNode(2, head);
        head = new ListNode(1, head);

        return head;
    }

    private ListNode getListNode2() {
        ListNode head = new ListNode(4);
        head = new ListNode(6, head);
        head = new ListNode(5, head);

        return head;
    }

    private void printListNode(ListNode head) {
        System.out.println("Printing values of ListNode: ");
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
