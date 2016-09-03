package com.leetcode.math;

/**
 * https://leetcode.com/problems/power-of-four/
 */
public class IsPowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }

        double result = Math.log(num) / Math.log(4.0);
        return result == Math.floor(result);
    }
}
