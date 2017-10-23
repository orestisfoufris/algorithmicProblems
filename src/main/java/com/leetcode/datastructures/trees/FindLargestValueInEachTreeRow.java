package com.leetcode.datastructures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/#/description
 */
public class FindLargestValueInEachTreeRow {

    @SuppressWarnings("unchecked")
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Long> max = new TreeMap<>();
        traverse(root, 1, max);

        List result = new ArrayList<>(max.size());
        result.addAll(max.values());

        return result;
    }

    private void traverse(TreeNode node, int level, Map<Integer, Long> max) {
        if (node != null) {
            long current = max.getOrDefault(level, Long.MIN_VALUE);
            if (node.val > current) {
                max.put(level, (long) node.val);
            }

            traverse(node.left, level + 1, max);
            traverse(node.right, level + 1, max);
        }
    }
}
