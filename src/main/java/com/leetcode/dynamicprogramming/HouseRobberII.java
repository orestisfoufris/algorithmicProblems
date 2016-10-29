package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * 29/10/2016.
 */
public class HouseRobberII {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(solve(0, nums.length - 2, nums, dp1), solve(1, nums.length - 1, nums, dp2));
    }

    private int solve(int index, int end, int nums[], int[] dp) {
        if (index == end) {
            return nums[index];
        }

        if (index > end) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int result = Math.max(nums[index] + solve(index + 2, end, nums, dp), solve(index + 1, end, nums, dp));
        dp[index] = result;

        return result;
    }
}
