package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 10;
        int base = 9;

        // for n = 2 it is 9 * 9 because of 0.
        // 0 can't be put on the front but it can be put after it.
        // after that we can exclude one digit and do 9 * 9 * 8 ... * 1
        for (int k = 2; k <= n && k <= 10; k++) {
            base = base * (9 - k + 2);
            result += base;
        }

        return result;
    }

}
