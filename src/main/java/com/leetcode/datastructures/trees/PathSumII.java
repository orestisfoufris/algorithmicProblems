package com.leetcode.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * 22/10/2016.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfs(root, sum, list, 0, result);

        return result;
    }

    private void dfs(TreeNode node, int sum, List<Integer> list, int count, List<List<Integer>> result) {
        if (node != null) {
            list.add(node.val);
            int newcount = count + node.val;

            // it is a leaf
            if (node.left == null && node.right == null) {
                if (newcount == sum) {
                    result.add(new ArrayList<>(list));
                }
            } else {
                dfs(node.left, sum, list, newcount, result);
                dfs(node.right, sum, list, newcount, result);
            }

            list.remove(list.size() - 1);
        }
    }

}
