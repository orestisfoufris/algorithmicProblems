package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0, result, new ArrayList<>(), candidates, 0, target);

        return result;
    }


    private void backtrack(int start, List<List<Integer>> result, List<Integer> prevState,
                                                        int[] cands, int count, int target) {

        if (count == target) {
            result.add(new ArrayList<>(prevState));
        }

        if (count > target) {
            return; // prevent further recursion
        }

        for(int i = start; i < cands.length; ++i) {
            prevState.add(cands[i]);
            backtrack(i, result, prevState, cands, count + cands[i], target);
            prevState.remove(prevState.size() - 1);
        }
    }
}
