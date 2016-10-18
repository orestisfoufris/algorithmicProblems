package com.leetcode.datastructures.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-iii/
 * 18/10/2016.
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        Map<TreeNode, int[]> cache = new HashMap<>();
        int[] result = solve(root, cache);

        return Math.max(result[0], result[1]);
    }

    private int[] solve(TreeNode root, Map<TreeNode, int[]> cache) {
        if (root == null) {
            return new int[2];
        }

        if (cache.containsKey(root)) {
            return cache.get(root);
        }

        int[] result = new int[2];
        result[0] = root.val + solve(root.left, cache)[1] + solve(root.right, cache)[1]; // with current node
        result[1] = Math.max(solve(root.left, cache)[0], solve(root.left, cache)[1]) +
                Math.max(solve(root.right, cache)[0], solve(root.right, cache)[1]); // without current node

        cache.putIfAbsent(root, result);
        return result;
    }

}
