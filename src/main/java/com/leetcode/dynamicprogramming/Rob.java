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

    public static void main(String[] args) {
        System.out.println(rob(new int[]{5, 4, 3, 3}));
        System.out.println(rob(new int[]{2, 3, 1, 1}));
        System.out.println(rob(new int[]{8, 4, 1, 2}));
    }
}