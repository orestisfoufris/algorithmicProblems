package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 27/09/2016.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            if (max < i) {
                max = i;
            }
        }

        return max;
    }
}
