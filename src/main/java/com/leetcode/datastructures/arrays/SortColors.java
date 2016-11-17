package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * 17/11/2016.
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;

        for (int i = 0; i <= two; ++i) {
            while (nums[i] == 2 && two > i) {
                swap(i, two--, nums);
            }

            while (nums[i] == 0 && i > zero) {
                swap(i, zero++, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
