package com.leetcode.datastructures.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 16/10/2016.
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        find(root, map, 0);

        result.addAll(map.values());

        return result;
    }

    private void find(TreeNode node, Map<Integer, Integer> points, int depth) {
        if (node != null) {
            points.put(depth, node.val);
            find(node.left, points, depth + 1);
            find(node.right, points, depth + 1);
        }
    }

}
