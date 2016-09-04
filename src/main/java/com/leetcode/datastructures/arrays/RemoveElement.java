package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        boolean found = false;
        int length = nums.length;

        int end = length - 1;
        int start = 0;

        for (int i = end; i >= 0; --i) {
            if (nums[i] != val) {
                end = i;
                found = true;
                break;
            }
        }

        if (!found) return 0;

        while (start <= end) {
            if (nums[start] == val) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                while(nums[end] == val && end > 0) {
                    end--;
                }
            }

            start++;
        }

        return ++end;
    }

}
