package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/burst-balloons/
 * 30/10/2016.
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int N = nums.length;
        int[][] dp = new int[N][N];

        for (int i = 1; i <= N; ++i) {
            for (int start = 0; start <= N - i; ++start) {
                int end = start + i - 1;

                for (int k = start; k <= end; ++k) {
                    int coins = nums[k] * checkOutOfBounds(nums, start - 1) * checkOutOfBounds(nums, end + 1);
                    coins += (k == start) ? 0 : dp[start][k - 1];
                    coins += (k == end) ? 0 : dp[k + 1][end];
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }

        return dp[0][N - 1];
    }


    private int checkOutOfBounds(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            return 1;
        }

        return array[index];
    }


    public int maxCoinsTopDown(int[] nums) {
        int[] numbers = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) {
                numbers[n++] = x;
            }
        }

        numbers[0] = numbers[n++] = 1;


        int[][] dp = new int[n][n];
        return burst(dp, numbers, 0, n - 1);
    }

    private int burst(int[][] dp, int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }

        if (dp[left][right] > 0) {
            return dp[left][right];
        }

        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] +
                                burst(dp, nums, left, i) + burst(dp, nums, i, right));

        return dp[left][right] = ans;
    }
}
