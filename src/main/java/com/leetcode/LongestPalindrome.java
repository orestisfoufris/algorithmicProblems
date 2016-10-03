package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome/
 * 03/10/2016.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int count = 0;
        for (Integer i : map.values()) {
            if (i >= 2) {
                if (i % 2 == 0) {
                    count += i;
                } else {
                    count += i - 1;
                }
            }
        }

        return s.length() - count > 0 ? count + 1 : count;
    }
}
