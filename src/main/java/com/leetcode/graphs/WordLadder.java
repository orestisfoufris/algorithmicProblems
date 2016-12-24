package com.leetcode.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * 24/12/2016.
 */
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> visited = new HashSet<>();

        Deque<String> deque = new ArrayDeque<>();
        deque.add(beginWord);
        deque.add("SENTINEL"); // used to mark levels

        visited.add(beginWord);

        int level = 1;

        while (!deque.isEmpty()) {
            String current = deque.poll();

            if (!current.equals("SENTINEL")) {
                for (int i = 0; i < current.length(); ++i) {
                    char[] copy = current.toCharArray();

                    for (char c = 'a'; c <= 'z'; ++c) {
                        copy[i] = c;
                        String temp = new String(copy);

                        if (temp.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordList.contains(temp) && !visited.contains(temp)) {
                            deque.offer(temp);
                            visited.add(temp);
                        }
                    }
                }
            } else {
                level = level + 1;
                if (!deque.isEmpty()) {
                    deque.add("SENTINEL");
                }
            }
        }

        return 0;
    }
}
