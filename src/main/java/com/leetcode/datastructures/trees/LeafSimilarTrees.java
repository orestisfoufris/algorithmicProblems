package com.leetcode.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        traverse(root1, one);
        traverse(root2, two);

        return one.equals(two);
    }

    private void traverse(TreeNode node, List<Integer> leafs) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafs.add(node.val);
            }

            traverse(node.left, leafs);
            traverse(node.right, leafs);
        }
    }
}
