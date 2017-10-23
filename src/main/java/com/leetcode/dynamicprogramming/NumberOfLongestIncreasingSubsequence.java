package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 */
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int result = 0;
        int max = 1;

        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            dp[i] = counter[i] = 1;

            for (int k = 0; k < i; ++k) {
                if (nums[i] > nums[k]) {
                    if (dp[i] == dp[k] + 1) {
                        counter[i] += counter[k];
                    }

                    if (dp[i] < dp[k] + 1){
                        dp[i] = dp[k] + 1;
                        counter[i] = counter[k];
                    }
                }
            }

            if (max == dp[i]) {
                result += counter[i];
            }

            if (max < dp[i]) {
                max = dp[i];
                result = counter[i];
            }
        }

        return result;
    }

}
