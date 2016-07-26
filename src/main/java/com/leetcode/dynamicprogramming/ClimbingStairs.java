package com.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        Map<Integer, Integer> computed = new HashMap<>();
        return climb(n, computed);
    }

    private static int climb(int n, Map<Integer, Integer> computed) {
        if (n == 1 || n == 0) { return 1; }
        if (n == 2) { return 2; }

        if (computed.containsKey(n)) {
            return computed.get(n);
        } else {
            int result = climb(n - 1, computed) + climb(n - 2, computed);
            computed.put(n, result);

            return result;
        }

    }
}
