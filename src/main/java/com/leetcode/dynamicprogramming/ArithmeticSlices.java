package com.leetcode.dynamicprogramming;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 * 26/10/2016.
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        if (A.length < 3) {
            return 0;
        }

        if (A[2] - A[1] == A[1] - A[0]) {
            dp[2] = 1;
        }

        for (int i = 3; i < A.length; ++i) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return IntStream.of(dp).sum(); // dreadful performance compared to a for loop
    }
}
