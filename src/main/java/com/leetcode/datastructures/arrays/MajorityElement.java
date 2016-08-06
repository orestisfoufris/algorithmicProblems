package com.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(int) Math.ceil(nums.length / 2)];
    }
}
