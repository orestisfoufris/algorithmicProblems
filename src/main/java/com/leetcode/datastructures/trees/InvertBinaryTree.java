package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return find(root);
    }

    private TreeNode find(TreeNode node) {

        if (node != null) {
            TreeNode left = find(node.left);
            TreeNode right = find(node.right);

            node.right = left;
            node.left = right;

            return node;
        }

        return null;
    }

    public TreeNode invertTreeAlternativeWay(TreeNode root) {
        invert(root);

        return root;
    }

    private void invert(TreeNode node) {
        if (node != null) {
            invert(node.left);
            invert(node.right);

            TreeNode left = node.left;
            TreeNode right = node.right;

            node.right = left;
            node.left = right;

        }
    }
}
