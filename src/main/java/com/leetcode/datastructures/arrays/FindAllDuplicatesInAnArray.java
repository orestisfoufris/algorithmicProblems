package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 25/10/2016.
 */
public class FindAllDuplicatesInAnArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int number = Math.abs(nums[i]);

            if (nums[number - 1] > 0) {
                nums[number - 1] *= -1;
            } else {
                result.add(number);
            }

        }

        return result;
    }
}
