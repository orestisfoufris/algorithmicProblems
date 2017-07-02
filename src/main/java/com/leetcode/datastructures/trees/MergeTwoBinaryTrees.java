package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/#/description
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return traverse(t1, t2);
    }

    private TreeNode traverse(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            TreeNode curr = new TreeNode(t1.val + t2.val);
            curr.left = traverse(t1.left, t2.left);
            curr.right = traverse(t1.right, t2.right);

            return curr;
        }

        if (t1 != t2) {
            return t1 == null ? t2 : t1;
        } else {
            return null;
        }
    }

}
