package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();

        backtrack(S, 0, "", result);

        return result;
    }

    private static void backtrack(String s, int i, String temp, List<String> result) {
        if (i >= s.length()) {
            result.add(temp);
        } else {
            char c = s.charAt(i);
            String substring = s.substring(i + 1);
            temp = temp.substring(0, i);

            if (!Character.isDigit(c)) {
                backtrack(
                        s,
                        i + 1,
                        temp + (c + "").toLowerCase() + substring,
                        result
                );

                temp = temp.substring(0, i);
                backtrack(
                        s,
                        i + 1,
                        temp + (c + "").toUpperCase() + substring,
                        result
                );
            } else {
                backtrack(
                        s,
                        i + 1,
                        temp + (c + "") + substring,
                        result
                );
            }
        }
    }
}
