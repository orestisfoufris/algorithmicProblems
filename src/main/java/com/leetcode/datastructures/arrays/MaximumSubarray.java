package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(nums[i], max + nums[i]);
            sum = Math.max(max, sum);
        }

        return sum;
    }
}
