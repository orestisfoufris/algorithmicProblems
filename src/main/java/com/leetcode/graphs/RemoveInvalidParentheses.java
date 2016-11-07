package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 07/11/2016.
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(result, 0, new char[] {'(', ')'}, s);

        return result;
    }

    private void remove(List<String> result, int last_j, char[] p, String s) {
        int invalidCounter = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == p[0]) { invalidCounter += 1; }
            if (s.charAt(i) == p[1]) { invalidCounter -= 1; }

            if (invalidCounter >= 0) {
                continue; // we haven't found any violations yet
            }

            // we found one. Start from the last removed parentheses
            // up to the index we searched for
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == p[1] && (j == last_j || s.charAt(j - 1) != p[1])) { // we want to remove the first ')'
                    remove(result, j, p, s.substring(0, j) + s.substring(j + 1, s.length()));
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (p[0] == '(') {
            // we have finished scanning the string from left to right
            // remove now unnecessary '('
            remove(result, 0, new char[]{')', '('}, reversed);
        } else {
            result.add(reversed);
        }
    }

}
