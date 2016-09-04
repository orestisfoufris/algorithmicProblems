package com.leetcode.datastructures.trees;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        discover(map, 0, root);

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> entry : map.values()) {
            result.add(entry);
        }

        Collections.reverse(result);
        return result;

    }

    private void discover(Map<Integer, List<Integer>> map, int level, TreeNode node) {

        if (node != null) {

            if (map.containsKey(level)) {
                List<Integer> l = map.get(level);
                l.add(node.val);
                map.put(level, l);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(level, list);
            }

            discover(map, level + 1, node.left);
            discover(map, level + 1, node.right);
        }
    }
}
