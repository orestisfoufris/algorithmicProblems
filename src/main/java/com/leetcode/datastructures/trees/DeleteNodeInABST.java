package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * 09/11/2016.
 */
public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) { // look right
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) { // look left
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode minimum = findMinimum(root.right);
                root.val = minimum.val;
                root.right = deleteNode(root.right, minimum.val);
            }
        }

        return root;
    }

    private TreeNode findMinimum(TreeNode root) {
        if (root != null && root.left != null) {
            return findMinimum(root.left);
        } else {
            return root;
        }
    }

}
