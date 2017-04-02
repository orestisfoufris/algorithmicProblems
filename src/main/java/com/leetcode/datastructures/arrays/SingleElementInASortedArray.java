package com.leetcode.datastructures.arrays;


public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int index = bsearch(nums,0, nums.length - 1);
        return nums[index];
    }

    private int bsearch(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }

        int mid = (end + start) >>> 1;

        if (nums[mid] == nums[mid ^ 1]) {
            return bsearch(nums, mid + 1, end);
        } else {
            return bsearch(nums, start, mid);
        }

    }

}
