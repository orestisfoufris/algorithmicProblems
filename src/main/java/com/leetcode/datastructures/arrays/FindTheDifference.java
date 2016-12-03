package com.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-difference/
 * 03/12/2016.
 */
public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; ++i) {
            if (a[i] != b[i]) {
                return b[i];
            }
        }

        return b[b.length - 1];
    }
}
