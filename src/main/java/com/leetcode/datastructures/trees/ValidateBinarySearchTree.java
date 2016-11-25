package com.leetcode.datastructures.trees;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 19/11/2016.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }

            pre = root;
            root = root.right;
        }

        return true;
    }

    public boolean isValidBSTRecursive(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

}
