package com.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        int len = Math.min(first.length, last.length);

        for (int i = 0; i < len; i++) {
            if (first[i] != last[i]) {
                return strs[0].substring(0,i);
            }
        }

        return strs[0];
    }
}
