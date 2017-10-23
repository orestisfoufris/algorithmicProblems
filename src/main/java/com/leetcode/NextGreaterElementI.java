package com.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/next-greater-element-i/#/description
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        HashMap<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            indices.put(nums[i], i);
        }

        for (int i = 0; i < findNums.length; ++i) {
            for (int j = indices.get(findNums[i]); j < nums.length; ++j) {
                int number = findNums[i];
                if (nums[j] > number) {
                    result[i] = nums[j];
                    break;
                }

                result[i] = -1;
            }
        }
        return result;
    }

}
