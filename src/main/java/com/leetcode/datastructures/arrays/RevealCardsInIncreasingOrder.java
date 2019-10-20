package com.leetcode.datastructures.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; ++i) {
            deque.offer(i);
        }

        for (int i = 0; i < n; ++i) {
            int index = deque.poll();
            result[index] = deck[i];
            if (i < n - 1) {
                deque.offer(deque.poll());
            }
        }

        return result;
    }
}
