package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0, result, new ArrayList<>(), candidates, 0, target);

        return result;
    }


    private void backtrack(int start, List<List<Integer>> result, List<Integer> prevState,
                           int[] cands, int count, int target) {

        if (count == target) {
            result.add(new ArrayList<>(prevState));
        } else if (count > target) {
            return;
        }

        for(int i = start; i < cands.length; ++i) {
            if (i > start && cands[i] == cands[i - 1]) {
                continue; // can't reuse the same number twice
            }

            prevState.add(cands[i]);
            backtrack(i + 1, result, prevState, cands, count + cands[i], target);
            prevState.remove(prevState.size() - 1);

        }
    }
}
