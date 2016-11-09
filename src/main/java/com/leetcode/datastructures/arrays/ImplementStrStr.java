package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/implement-strstr/
 * 09/11/2016.
 */
public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        } else if (needle.length() == 0 || (needle.length() == 0 && haystack.length() == 0)) {
            return 0;
        }

        return KMP(haystack, needle, generatePrefixTable(needle.toCharArray()));
    }

    private static int[] generatePrefixTable(char[] needle) {
        int size = needle.length;
        int[] prefix = new int[size];
        prefix[0] = -1;
        int i = -1;

        for (int j = 1; j < size; ++j) {
            while (i > -1 && needle[i + 1] != needle[j]) {
                i = prefix[i];
            }

            if (needle[i + 1] == needle[j]) {
                i++;
            }

            prefix[j] = i;
        }

        return prefix;

    }

    private static int KMP(String haystack, String needle, int[] prefixTable) {
        int j = -1;
        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.charAt(i) != needle.charAt(j + 1)) {
                while (j > -1 && haystack.charAt(i) != needle.charAt(j + 1)) {
                    j = prefixTable[j];
                }
            }

            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }

            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }

}
