package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;

        if (i == 0) return 0;

        int k = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i - 1] < nums[k]) {
                nums[i] = nums[k];
                i++;
            }
            k++;
        }

        return i;
    }
}
