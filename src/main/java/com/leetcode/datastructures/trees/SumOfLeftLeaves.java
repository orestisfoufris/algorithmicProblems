package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 03/10/2016.
 */
public class SumOfLeftLeaves {
    private int count = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        traverse(root, false);
        return count;
    }

    private void traverse(TreeNode node, boolean isLeft){
        if (node != null) {
            if (isLeft && (node.left == null && node.right == null)) {
                count += node.val;
            }

            traverse(node.left, true);
            traverse(node.right, false);
        }
    }
}
