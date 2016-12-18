package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/reverse-string/
 * 18/12/2016.
 */
public class ReverseString {

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
        }

        return sb.reverse().toString();
    }
}
