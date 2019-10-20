package com.leetcode.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> nums = new ArrayList<>();
        t(root, nums);
        return sum(L, R, nums);
    }

    private void t(TreeNode node, List<Integer> list) {
        if (node != null) {
            t(node.left, list);
            list.add(node.val);
            t(node.right, list);
        }
    }

    private int sum(int l, int r, List<Integer> nums) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) >= l && nums.get(i) <= r) {
                count += nums.get(i);
            }
        }

        return count;
    }
}
