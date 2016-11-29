package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * 29/11/2016.
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> numbers = new ArrayList<>(n);

        for (int i = 1; i <= n; ++i) {
            numbers.add(i);
        }

        for (int i = 0; i < numbers.size(); ++i) {
            backtrack(numbers, result, i, new ArrayList<>(2), k);
        }

        return result;
    }

    private static void backtrack(List<Integer> nums, List<List<Integer>> result,
                           int start, List<Integer> temp, int k) {

        if (start < nums.size()) {
            temp.add(nums.get(start));

            if (temp.size() == k) {
                result.add(new ArrayList<>(temp));
            }

            for (int i = start + 1; i < nums.size(); ++i) {
                backtrack(nums, result, i, temp, k);
            }
            temp.remove(temp.size() - 1);
        }
    }
}
