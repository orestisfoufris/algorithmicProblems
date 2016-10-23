package com.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 23/10/2016.
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];

        result[0] = 1;
        for (int i = 1; i < N; i++) {
            // calculate product of all elements left to i
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = N - 1; i >= 0; i--) {
            // calculate product of all elements right to i
            // using the product from left to i
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }

}
