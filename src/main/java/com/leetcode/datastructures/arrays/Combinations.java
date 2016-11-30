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

        backtrack(result, new ArrayList<>(2), k, n, 1);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i <= n + 1 - k; ++i) {
                temp.add(i);
                backtrack(result, temp, k - 1, n, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
