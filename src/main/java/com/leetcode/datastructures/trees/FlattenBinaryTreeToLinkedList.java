package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 23/10/2016.
 */
public class FlattenBinaryTreeToLinkedList {
    private TreeNode previous = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            node.left = null;
            if (left != null) {
                node.right = left;
                while (left.right != null) {
                    left = left.right;
                }

                left.right = right;
            }

            node = node.right;
        }
    }

    public void flattenPostOrder(TreeNode root) {
        if (root != null) {
            flattenPostOrder(root.right);
            flattenPostOrder(root.left);

            root.left = null;
            root.right = previous;

            previous = root;
        }
    }

}
