package com.leetcode.graphs;

/**
 * https://leetcode.com/problems/decode-string/
 * 19/10/2016.
 */
public class DecodeString {
    private int i = 0;

    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }

        return dfs(s, 0);
    }

    private String dfs(String s, int index) {
        if (index >= s.length()) {
            return "";
        }

        StringBuilder number = new StringBuilder();
        StringBuilder letters = new StringBuilder();

        for (i = index; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                number.append(current);
            }
            if (Character.isLetter(current)) {
                letters.append(current);
            }

            if (current == '[') {
                String result = dfs(s, i + 1);
                for (int t = 0; t < Integer.valueOf(number.toString()); ++t) {
                    letters.append(result);
                }
                number.delete(0, number.length());
            } else if (current == ']') {
                return letters.toString();
            }
        }

        return letters.toString();
    }
}
