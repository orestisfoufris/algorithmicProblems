package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String p = f(pattern);

        List<String> result = new ArrayList<>();
        for (String s : words) {
            if (f(s).equals(p)) {
                result.add(s);
            }
        }

        return result;
    }


    private String f(String word) {
        Map<Character, Integer> mapping = new HashMap<>();
        int index = 0;
        StringBuilder s = new StringBuilder();

        for (char c: word.toCharArray()) {
            if (mapping.containsKey(c)) {
                s.append(mapping.get(c));
            } else {
                mapping.put(c, ++index);
                s.append(index);
            }
        }

        return s.toString();
    }
}
