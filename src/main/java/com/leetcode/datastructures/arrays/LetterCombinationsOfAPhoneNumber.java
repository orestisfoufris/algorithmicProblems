package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations2(String digits) {
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0 || digits.isEmpty()) {
            return new ArrayList<>();
        }

        result.add("");

        for (int i = 0; i < digits.length(); ++i) {
            String current = map[digits.charAt(i) - '0'];
            while (result.peek().length() == i) {
                String firstIn = result.remove();
                for (Character c : current.toCharArray()) {
                    result.add(firstIn + c);
                }
            }
        }

        return result;
    }
}
