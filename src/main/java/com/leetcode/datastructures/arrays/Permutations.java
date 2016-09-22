package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, result);

        return result;
    }


    private void backtrack(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }

            result.add(list);
        }

        for (int i = start; i < nums.length; ++i) {
            swap(i, start, nums);
            backtrack(start + 1, nums, result);
            swap(start, i, nums);
        }

    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        Permutations p = new Permutations();
        System.out.println(p.permute(new int[]{1,2,3}));
    }
}
