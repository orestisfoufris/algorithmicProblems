package com.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        long num = n ^ 0xffffffffL;
        int sum = 0;
        int one = 1;

        for (int i = 0; i < 32; ++i) {
            if ((num & one) > 0) {
                sum++;
            }
            one = one << 1;
        }

        return 32 - sum;
    }

}
