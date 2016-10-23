package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * 23/10/2016.
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int find(TreeNode node, int sum) {
        if (node != null) {
            int add = (node.val == sum) ? 1 : 0;

            return add + find(node.left, sum - node.val)  +
                    find(node.right, sum - node.val);
        }

        return 0;
    }

}
