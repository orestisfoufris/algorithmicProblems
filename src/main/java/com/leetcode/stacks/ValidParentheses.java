package com.leetcode.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            if (deque.isEmpty() && (s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}')) {
                return false;
            }

            if (s.charAt(i) == ']') {
                if (deque.pop() != '[') {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (deque.pop() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (deque.pop() != '{') {
                    return false;
                }
            } else {
                deque.push(s.charAt(i));
            }
        }

        return deque.isEmpty();
    }
}
