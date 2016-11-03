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

}
