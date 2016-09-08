package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {

    private boolean found = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        find(root, sum);

        return found;
    }

    private void find(TreeNode node, int sum) {
        if (node != null) {
            sum = sum - node.val;
            found |= (sum == 0 && node.right == null && node.left == null);

            find(node.left, sum);
            find(node.right, sum);
        }
    }

}
