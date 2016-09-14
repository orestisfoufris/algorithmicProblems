package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] array = s.trim().split(" ");

        return array[array.length - 1].length();
    }
}
