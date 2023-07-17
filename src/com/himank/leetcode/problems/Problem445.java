package com.himank.leetcode.problems;

import java.util.Stack;

public class Problem445 {

    // https://leetcode.com/problems/add-two-numbers-ii/description/
    public static void main(String[] args) {
        ListNode root1 = new ListNode(7);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(4);
        root1.next.next.next = new ListNode(3);

        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(6);
        root2.next.next = new ListNode(4);

        ListNode answer = addTwoNumbers(root1, root2);
        while (answer != null) {
            System.out.println(answer.val + "  ");
            answer = answer.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int totalSum = 0, carry = 0;
        ListNode ans = new ListNode();
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) totalSum += s1.pop();
            if (!s2.empty()) totalSum += s2.pop();

            ans.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
        }

        return carry == 0 ? ans.next : ans;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode() {

        }
    }
}
