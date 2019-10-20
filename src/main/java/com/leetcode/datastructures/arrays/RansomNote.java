package com.leetcode.datastructures.arrays;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[100];

        for (char c : magazine.toCharArray()) {
            letters[Character.getNumericValue(c)]++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (letters[Character.getNumericValue(c)]-- <= 0) {
                return false;
            }
        }

        return true;
    }
}
