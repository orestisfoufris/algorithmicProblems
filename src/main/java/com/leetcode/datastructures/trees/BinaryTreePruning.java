package com.leetcode.datastructures.trees;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        traverse(root);
        return root;
    }


    private void traverse(TreeNode node) {
        if (node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            traverse(left);
            traverse(right);

            if (left != null && left.right == null && left.left == null && left.val == 0) {
                node.left = null;
            }

            if (right != null && right.right == null && right.left == null && right.val == 0) {
                node.right = null;
            }
        }
    }
}