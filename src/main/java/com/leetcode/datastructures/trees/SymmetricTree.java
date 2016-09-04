package com.leetcode.datastructures.trees;

import java.util.*;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        discover(left, right, root, false, true);

        if (left.size() != right.size()) {
            return false;
        }

        Collections.reverse(right);

        for (int i = 0; i < left.size(); ++i) {
            if (!left.get(i).equals(right.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void discover(List<Integer> left, List<Integer> right, TreeNode node, boolean isLeft, boolean root) {
        if (node != null) {
            discover(left, right, node.left, true, false);

            if (isLeft && !root) {
                left.add(node.val);
            } else if (!isLeft && !root) {
                right.add(node.val);
            }

            discover(left, right, node.right, false, false);
        }
    }

}
