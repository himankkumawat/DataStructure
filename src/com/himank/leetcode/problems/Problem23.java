package com.himank.leetcode.problems;

public class Problem23 {

    // https://leetcode.com/problems/merge-k-sorted-lists/description/
    public static void main(String[] args) {
        ListNode[] lists = getLists();
        ListNode result = mergeKLists(lists);

        ListNode temp = result;
        while(temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return mergeList(lists, 0, lists.length-1);
    }

    private static ListNode mergeList(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];

        int mid = left + (right - left)/2;
        ListNode first = mergeList(lists, left, mid);
        ListNode second = mergeList(lists, mid+1, right);
        return mergeList(first, second);
    }

    private static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 !=  null) {
            current.next = list1;
        }
        if(list2 != null) {
            current.next = list2;
        }
        return temp.next;
    }

    private static ListNode[] getLists() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        return new ListNode[]{list1, list2, list3};
    }

    public static class ListNode {
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
}
