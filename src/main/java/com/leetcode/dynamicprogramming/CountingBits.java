package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;

        for (int i = 1; i <= num; ++i) {
            count[i] = count[i & (i - 1)] + 1;
        }

        return count;
    }

    public int[] countBits2(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = dp[i / 2];
            }
        }

        return dp;
    }
}
