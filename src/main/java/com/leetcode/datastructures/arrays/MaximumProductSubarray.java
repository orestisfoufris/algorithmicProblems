package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            // swap as we hit negative
            if (nums[i] <= 0) {
                min = min ^ max;
                max = min ^ max;
                min = min ^ max;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            result = Math.max(result, max);

        }

        return result;
    }
}
