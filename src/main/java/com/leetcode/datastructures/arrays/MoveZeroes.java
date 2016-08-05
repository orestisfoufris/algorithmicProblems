package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int k = j;k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}
