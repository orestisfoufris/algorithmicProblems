package com.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/reverse-bits/
 * 04/10/2016.
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        if (n == 0){
            return 0;
        }

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;

            if ((n & 1) == 1) {
                result++;
            }

            n >>= 1;
        }

        return result;
    }
}
