package com.leetcode.dynamicprogramming;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 27/10/2016.
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();

        if (sum == 0) {
            return true;
        } else if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[nums.length][sum];

        return solve(nums, 0, 0, target, dp);
    }

    private boolean solve(int[] nums, int index, int sum, int target, int[][] dp) {
        if (index >= nums.length || sum > target) {
            return false;
        }

        if (sum == target) {
            return true;
        }

        if (dp[index][sum] != 0) {
            return dp[index][sum] == 1;
        }

        boolean result = solve(nums, index + 1, sum, target, dp) ||
                solve(nums, index + 1, sum + nums[index], target, dp);

        dp[index][sum] = result ? 1 : 2;
        return result;
    }

    public boolean canPartitionBottomsUp(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }

        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {
            return false;
        }
        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }

        return dp[target];
    }

}
