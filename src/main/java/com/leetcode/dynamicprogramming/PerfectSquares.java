package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares/
 * 05/11/2016.
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int i = 0;
        while (++i * i <= n) {
            for (int j = i * i; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - (i * i)] + 1);
            }
        }

        return dp[n];
    }
}
