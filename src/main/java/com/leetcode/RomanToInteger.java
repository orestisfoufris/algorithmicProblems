package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            Integer value = map.get(s.charAt(i));

            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                count -= value;
            } else {
                count += value;
            }

        }

        return count;
    }

}
