package com.leetcode.math;

/**
 * https://leetcode.com/problems/palindrome-number/
 * NOTE: do not use extra space
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int y = x;
        int reversed = 0;

        while (y != 0) {
            reversed = reversed * 10 + y % 10;
            y /= 10;
        }

        return x == reversed;
    }
}
