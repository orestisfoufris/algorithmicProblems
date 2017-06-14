package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * 30/10/2016.
 */
public class GuessNumberHigherOrLowerII {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        return minMax(1, n, dp);
    }

    private int minMax(int start, int end, int[][] dp) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        // base cases
        if (start >= end) {
            return 0;
        } else if (start >= end - 2) {
            return dp[start][end] = end - 1;
        }

        int mid = (start + (end - start) / 2) - 1;
        int min = Integer.MAX_VALUE;

        while (mid < end) {
            int left = minMax(start, mid - 1, dp);
            int right = minMax(mid + 1, end, dp);

            min = Math.min(min, mid + Math.max(left, right));
            mid++;
        }

        return dp[start][end] = min;
    }

    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return solve(1, n, dp);
    }

    private int solve(int start, int end, int[][] dp) {
        if (start >= end) return 0;

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int result = Integer.MAX_VALUE;

        for (int i = start; i <= end; ++i) {
            result = Math.min(result, i + Math.max(minMax(start, i - 1, dp), minMax(i + 1, end, dp)));
        }

        return dp[start][end] = result;
    }

}
