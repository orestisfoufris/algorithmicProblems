package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LCAEasy {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            // both on the left
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            // both on the right
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // they split between left and right so LCA is @param root
            return root;
        }
    }
}
