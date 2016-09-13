package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] match = str.split(" ");

        if (patterns.length != match.length) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < patterns.length; ++i) {
            if (!Objects.equals(map.put(patterns[i], i), map2.put(match[i], i))) {
                return false;
            }
        }

        return true;
    }

}
