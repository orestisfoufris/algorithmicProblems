package com.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 23/10/2016.
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;

        for (int i = 1; i < n; ++i) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int right = nums[n - 1];
        System.out.println(Arrays.toString(output));

        for (int i = n - 2; i >= 0; --i) {
            output[i] = output[i] * right;
            right *= nums[i];
        }

        return output;
    }

}
