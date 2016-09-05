package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return root == null || !countHeight(root).isUnbalanced;
    }

    private Answer countHeight(TreeNode node) {
        if (node != null) {
            Answer left = countHeight(node.left);
            Answer right = countHeight(node.right);

            boolean b = Math.abs(left.height - right.height) > 1;
            boolean isUnB = left.isUnbalanced || right.isUnbalanced;

            return new Answer(isUnB | b, Math.max(left.height, right.height) + 1);

        } else {
            return new Answer(false, 0);
        }
    }

    private static class Answer {
        boolean isUnbalanced;
        int height;

        Answer(boolean b, int h) {
            this.isUnbalanced = b;
            this.height = h;
        }
    }

}
