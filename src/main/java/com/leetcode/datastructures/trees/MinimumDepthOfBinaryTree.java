package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        return find(root, 0);
    }

    private int find(TreeNode node, int counter) {

        if (node != null) {

            if (node.left == null && node.right == null){
                return counter + 1;
            }

            int left = find(node.left, counter);
            int right = find(node.right, counter);

            if (left == counter || right == counter) {
                return Math.max(left, right) + 1;
            }

            return Math.min(left, right) + 1;

        } else {
            return counter;
        }
    }

}
