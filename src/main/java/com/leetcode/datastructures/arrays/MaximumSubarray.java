package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int min = Integer.MIN_VALUE;
        int sum = 0;
        int max = 0;

        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(0, max + nums[i]);
            sum = Math.max(max, sum);

            min = Math.max(min, nums[i]);
        }

        if (sum == 0 && nums.length > 0) {
            return min;
        }

        return sum;
    }
}
