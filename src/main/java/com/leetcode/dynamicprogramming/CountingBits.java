package com.leetcode.dynamicprogramming;

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

}
