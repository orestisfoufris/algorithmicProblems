package com.leetcode.datastructures.trees;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        return create(nums, 0, nums.length);
    }

    private TreeNode create(int[] nums, int start, int end) {
        // base
        if (start >= end || start < 0 || end > nums.length || end < 0 || start > nums.length) {
            return null;
        }

        int index = findMax(nums, start, end);
        TreeNode node = new TreeNode(nums[index]);

        node.left = create(nums, start, index);
        node.right = create(nums, index + 1, end);

        return node;

    }
    private int findMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = start; i < end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        return index;
    }

}
