package com.himank.trees;

public class ValidateBST {

    // https://leetcode.com/problems/validate-binary-search-tree/
    public static void main(String[] args) {
        int[] nums = {5, 1, -1, -1, 4, 3, -1, -1, 6, -1, -1};
        Node root = CountTotalNodes.buildTree(nums);
        System.out.println("Tree is valid? : " + isValidBST(root));
    }

    public static boolean isValidBST(Node root) {
        return validate(root, null, null);
    }

    private static boolean validate(Node root, Integer low, Integer high) {
        if (root == null)
            return true;
        if ((low != null && root.data <= low) || (high != null && root.data >= high)) {
            return false;
        }
        return validate(root.left, low, root.data) && validate(root.right, root.data, high);
    }
}
