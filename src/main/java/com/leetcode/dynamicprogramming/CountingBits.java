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

    public static void main(String[] args) {
        CountingBits c = new CountingBits();
        System.out.println(Arrays.toString(c.countBits(15)));
    }
}
