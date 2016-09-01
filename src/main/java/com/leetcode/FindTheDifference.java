package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        Set<Character> chars = new HashSet<>();

        sieveString(s, chars);
        sieveString(t, chars);

        return chars.iterator().next();
    }

    private void sieveString(String string, Set<Character> chars) {
        for (int i = 0; i < string.length(); ++i) {
            char current = string.charAt(i);

            if (chars.contains(current)) {
                chars.remove(current);
            } else {
                chars.add(current);
            }
        }
    }

}
