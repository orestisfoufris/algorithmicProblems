package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 29/12/2016.
 */
public class LongestPalindromicSubstring {

    private int leftIndex;
    private int maxLength;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; ++i) {
            find(s, i, i);
            find(s, i, i + 1);
        }

        return s.substring(leftIndex, leftIndex + maxLength);
    }

    private void find(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (maxLength < right - left - 1) {
            leftIndex = left + 1;
            maxLength = right - left - 1;
        }
    }

}
