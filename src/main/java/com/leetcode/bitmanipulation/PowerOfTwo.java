package com.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n != 0 && !(Long.bitCount(n) > 1);
    }
}
