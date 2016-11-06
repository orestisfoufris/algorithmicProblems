package com.leetcode.graphs;

import com.leetcode.datastructures.trees.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 06/11/2016.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    // 1 ms
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        solve(result, 1, root);

        return result;
    }

    private void solve(List<List<Integer>> result, int level, TreeNode node) {
        if (node != null) {
            if (level > result.size()) {
                result.add(new LinkedList<>());
            }

            LinkedList<Integer> list = (LinkedList<Integer>) result.get(level);
            if (level % 2 != 0) {
                list.addLast(node.val);
            } else {
                list.addFirst(node.val);
            }

            solve(result, level + 1, node.left);
            solve(result, level + 1, node.right);
        }
    }

    // this implementation is a bit slow
    public List<List<Integer>> zigzagLevelOrderSlow(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();

        find(map, 1, root);

        for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private void find(Map<Integer, LinkedList<Integer>> map, int level, TreeNode node) {
        if (node != null) {
            LinkedList<Integer> list = map.computeIfAbsent(level, key -> new LinkedList<>());
            if (level % 2 != 0) {
                list.addLast(node.val);
            } else {
                list.addFirst(node.val);
            }

            find(map, level + 1, node.left);
            find(map, level + 1, node.right);
        }
    }
}
