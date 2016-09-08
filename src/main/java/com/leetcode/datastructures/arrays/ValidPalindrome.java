package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.trim().replaceAll(" ","").replaceAll(("[^A-Za-z0-9 ]"), "").toLowerCase();

        int end = s.length() - 1;
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(end)) {
                return false;
            }
            end--;
        }

        return true;
    }
}
