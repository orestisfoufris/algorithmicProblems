package com.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> computed = new HashMap<>();

        return solve(nums, target, computed);
    }

    private int solve(int[] nums, int target, Map<Integer, Integer> computed) {
        if (target < 0) { return 0; }
        if (target == 0) { return 1; }

        if (computed.containsKey(target)) {
            return computed.get(target);
        }

        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            int count =  solve(nums, target - nums[i], computed);
            result += count;
        }

        computed.put(target, result);

        return result;
    }

}
