package com.leetcode;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        int j = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int c = (int) s.charAt(i) - 64;
            result += c * (int) Math.pow(26, j);
            j++;
        }

        return result;
    }

}
