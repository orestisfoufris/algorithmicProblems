package com.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int number = 0;

        for (int i = 0; i < nums.length; ++i) {
            number ^= nums[i];
        }

        return number;
    }

}
