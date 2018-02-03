package com.leetcode.dynamicprogramming;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
    }

    private int solve(int[] cost, int i, int[] dp) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int result = cost[i] + Math.min(solve(cost, i + 1, dp), solve(cost, i + 2, dp));

        return dp[i] = result;
    }
}
