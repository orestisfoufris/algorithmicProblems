package com.leetcode.datastructures.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 29/12/2016.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));

                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }

        return max;
    }

    // to slow
    public int lengthOfLongestSubstringBruteForce(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); ++i) {
            Set<Character> set = new HashSet<>();
            int count = 0;

            for (int j = i; j < s.length(); ++j) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    count++;
                } else {
                    break;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
