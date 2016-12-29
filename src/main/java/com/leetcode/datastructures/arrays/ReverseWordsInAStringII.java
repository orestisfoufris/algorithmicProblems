package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * 29/12/2016.
 */
public class ReverseWordsInAStringII {

    public static void reverseWords(char[] s) {
        String[] ar = new String(s).trim().split(" ");
        int l = 0;

        for (int j = ar.length - 1; j >= 0; --j) {
            String current = ar[j];
            for (int i = 0; i < current.length(); ++i) {
                s[l++] = current.charAt(i);
            }

            if (j > 0) {
                s[l++] = ' ';
            }
        }
    }
}
