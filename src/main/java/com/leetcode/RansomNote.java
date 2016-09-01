package com.leetcode;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[150];
        int[] m = new int[150];

        for (int i = 0 ; i < magazine.length(); ++i) {
            int num = Character.getNumericValue(magazine.charAt(i));
            m[num] = m[num] + 1;
        }

        for (int i = 0 ; i < ransomNote.length(); ++i) {
            int num = Character.getNumericValue(ransomNote.charAt(i));
            r[num] = r[num] + 1;
        }

        for (int i = 0 ; i < 150; ++i) {
            if (r[i] != 0 && r[i] > m[i]) {
                return false;
            }
        }

        return true;
    }
}
