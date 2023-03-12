package com.himank.leetcode.problems;

public class Problem109 {

    // https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
    public static void main(String[] args) {
        Problem109 solution = new Problem109();
        ListNode head = solution.getListNode();
        TreeNode root = solution.sortedListToBST(head);
        System.out.println(root.val);
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int[] arr = new int[size];
        temp = head;
        int index = 0;
        while (temp != null) {
            arr[index++] = temp.val;
            temp = temp.next;
        }
        return insert(null, arr, 0, size);
    }

    private TreeNode insert(TreeNode root, int[] arr, int start, int end) {
        if (end < 0 || start >= arr.length || start > end) return null;
        int mid = start + (end - start) / 2;
        root = new TreeNode(arr[mid]);
        root.left = insert(root.left, arr, start, mid - 1);
        root.right = insert(root.right, arr, mid + 1, end);
        return root;
    }

    private ListNode getListNode() {
        ListNode head = new ListNode(-10);
        ListNode temp = head;
        temp.next = new ListNode(-3);
        temp = temp.next;
        temp.next = new ListNode(0);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(9);
        return head;
    }

    private static class ListNode {
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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
