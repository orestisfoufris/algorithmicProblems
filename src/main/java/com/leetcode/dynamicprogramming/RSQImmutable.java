package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RSQImmutable {
    private int[] nums;

    public RSQImmutable(int[] nums) {
        int[] n = new int[nums.length];
        int count = 0;

        for (int i = 0; i < nums.length; ++i) {
            count += nums[i];
            n[i] = count;
        }

        this.nums = n;
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return nums[j];
        }

        return nums[j] - nums[i - 1];
    }
}