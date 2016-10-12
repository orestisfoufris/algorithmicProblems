package com.leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 04/10/2016.
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) {
            x = x * -1;
            minus = true;
        }

        StringBuilder s = new StringBuilder(String.valueOf(x)).reverse();
        Integer result = 0;
        try {
            result = Integer.valueOf(s.toString());
        } catch (NumberFormatException ex) {
            // do nothing
        }

        return minus ? -result : result;
    }

}
