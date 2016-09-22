package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, nums.length); ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if ((i & (1 << j)) > 0) {
                    list.add(nums[j]);
                }
            }

            result.add(list);
        }

        return result;
    }
}
