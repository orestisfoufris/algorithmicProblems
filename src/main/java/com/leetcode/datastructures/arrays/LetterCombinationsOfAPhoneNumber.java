package com.leetcode.datastructures.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        map.put('2', "abc"); map.put('3', "def");map.put('4', "ghi");
        map.put('5', "jkl"); map.put('6', "mno"); map.put('7', "pqrs");
        map.put('8', "tuv"); map.put('9', "wxyz");

        backtrack(result, 0, "", digits);

        return result;
    }

    private void backtrack(List<String> result, int offset, String prefix, String digits) {
        if (offset < digits.length()) {
            String current = map.get(digits.charAt(offset));

            for (int i = 0; i < current.length(); ++i) {
                backtrack(result, offset + 1, prefix + current.charAt(i), digits);
            }
        } else {
            result.add(prefix);
        }
    }

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
