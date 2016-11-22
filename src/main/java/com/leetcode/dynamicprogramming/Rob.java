package com.leetcode.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;

public class Rob {

    public static int rob(int[] nums) {
        int result = 0;
        Map<Integer, Integer> computed = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            result = Math.max(find(i, nums, computed), result);
        }

        return result;
    }

    private static int find(int i, int[] nums, Map<Integer, Integer> computed) {
        if (i == 0) {
            return nums[i];
        }

        if (i == 1) {
            return Math.max(nums[0], nums[i]);
        }

        if (computed.containsKey(i)) {
            return computed.get(i);
        }

        int temp = Math.max(find(i - 2, nums, computed) + nums[i], find(i - 1, nums, computed));
        computed.put(i, temp);

        return temp;
    }

    public int robBottomUp(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] dp = new int[n + 1];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; ++i) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[n - 1];
        }
    }

}