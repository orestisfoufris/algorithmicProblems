package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LCAMedium {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (!contains(root, p) || !contains(root, q)) {
            // tree is missing q or p node
            return null;
        }

        return helper(root, q, p);
    }

    private TreeNode helper(TreeNode root, TreeNode q, TreeNode p) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) { // a node can be a descendant of itself
            return root;
        }

        boolean is_p_left = contains(root.left, p);
        boolean is_q_left = contains(root.left, q);

        if (is_p_left != is_q_left) {
            // paths diverge so...
            return root;
        }

        return (is_p_left) ? helper(root.left, q, p) : helper(root.right, q, p);
    }

    private boolean contains(TreeNode node, TreeNode p) {
        if (node == null) {
            return false;
        }

        if (node == p) {
            return true;
        } else {
            return contains(node.left, p) || contains(node.right, p);
        }
    }

    // faster but will fail if p or q not in the tree
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if left and right are not null we have found the LCA (root)
        return left == null ? right : (right == null ? left : root);
    }

}
