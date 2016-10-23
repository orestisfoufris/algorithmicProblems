package com.leetcode.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 23/10/2016.
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int count = root.val + sum * 10;
        if (root.left == null && root.right == null) {
            return count;
        }

        return dfs(root.left, count) + dfs(root.right, count);
    }

    // bit slow
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();

        count(root, list, new StringBuilder());
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private void count(TreeNode node, List<Integer> list, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val);

            if (node.right == null && node.left == null) {
                list.add(Integer.valueOf(sb.toString()));
            }

            count(node.left, list, sb);
            count(node.right, list, sb);

            int size = sb.toString().length();
            sb.delete(size - 1, size);
        }
    }

}
