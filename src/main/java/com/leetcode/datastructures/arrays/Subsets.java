package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); ++i) {
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

    public static List<List<Integer>> subsetsBacktracking(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        backtrack(0, lists, nums, new ArrayList<>());
        return lists;
    }

    private static void backtrack(int start, List<List<Integer>> lists, int[] nums, List<Integer> prev) {
        lists.add(new ArrayList<>(prev));

        for (int j = start; j < nums.length; ++j) {
            prev.add(nums[j]);
            backtrack(j + 1, lists, nums, prev);
            prev.remove(prev.size() - 1);
        }

    }
}
