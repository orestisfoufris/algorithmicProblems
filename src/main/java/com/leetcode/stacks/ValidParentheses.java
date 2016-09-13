package com.leetcode.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        if (s.isEmpty()) {
            return true;
        } else {
            deque.push(s.charAt(0));
        }

        for (int i = 1; i < s.length(); ++i) {
            char curr = s.charAt(i);

            if (curr == ')') {
                Character c = deque.pollFirst();
                if (c == null || !c.equals('(')) {
                    return false;
                }
            } else if (curr == ']') {
                Character c = deque.pollFirst();
                if (c == null || !c.equals('[')) {
                    return false;
                }
            } else if (curr == '}') {
                Character c = deque.pollFirst();
                if (c == null || !c.equals('{')) {
                    return false;
                }
            } else {
                deque.push(curr);
            }
        }

        return deque.isEmpty();
    }
}
