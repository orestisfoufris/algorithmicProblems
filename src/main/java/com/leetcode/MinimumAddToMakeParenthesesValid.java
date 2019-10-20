package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Deque<Character> d = new ArrayDeque<>();
        int count = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                d.push(c);
            } else {
                boolean empty = d.isEmpty();
                if (!empty && d.peek() == '(') {
                    d.pop();
                } else {
                    count++;
                }
            }
        }

        return d.size() + count;
    }
}
