package com.leetcode.datastructures.stack;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/next-greater-element-ii/#/description
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            d.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; --i) {
            result[i] = -1;

            if (d.peek() > nums[i]) {
                result[i] = d.peek();
            } else {
                while (!d.isEmpty() && d.peek() <= nums[i]) {
                    d.poll();
                }

                if (!d.isEmpty()) {
                    result[i] = d.peek();
                }
            }

            d.push(nums[i]);
        }

        return result;
    }
}
