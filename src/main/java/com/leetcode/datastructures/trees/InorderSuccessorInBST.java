package com.leetcode.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 30/12/2016.
 */
public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> nodes = new ArrayList<>();
        traverse(nodes, root);

        for (int i = 0; i < nodes.size() - 1; ++i) {
            if (nodes.get(i) == p) {
                return nodes.get(i + 1);
            }
        }

        return null;
    }


    private void traverse(List<TreeNode> nodes, TreeNode root) {
        if (root != null) {
            traverse(nodes, root.left);
            nodes.add(root);
            traverse(nodes, root.right);
        }
    }
}
