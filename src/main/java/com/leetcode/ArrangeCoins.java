package com.leetcode;

/**
 * https://leetcode.com/problems/arranging-coins/
 * 11/11/2016.
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int count = 0;

        for (int i = 1; i <= n; ++i) {
            if (n - i >= 0) {
                count++;
            }
            n = n - i;
        }

        return count;
    }
}
