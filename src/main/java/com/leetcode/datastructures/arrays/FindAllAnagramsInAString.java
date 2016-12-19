package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 19/12/2016.
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] characters = new int[256];

        for (char c : p.toCharArray()) {
            characters[c]++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {

            if (characters[s.charAt(right)] >= 1) {
                count--;
            }

            characters[s.charAt(right)]--;
            right++;

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length() ) {

                if (characters[s.charAt(left)] >= 0) {
                    count++;
                }

                characters[s.charAt(left)]++;
                left++;
            }
        }

        return list;
    }

}
