package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/paint-house/
 * 01/01/2017.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0]; // paint first home red
        dp[0][1] = costs[0][1]; // paint first home blue
        dp[0][2] = costs[0][2]; // paint first home green

        for (int i = 1; i < costs.length; ++i) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]); // red
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]); // blue
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]); // green
        }

        int n = costs.length - 1;
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
