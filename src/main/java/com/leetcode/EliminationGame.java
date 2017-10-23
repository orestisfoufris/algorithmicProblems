package com.leetcode;

/**
 * https://leetcode.com/problems/elimination-game/#/description
 */
public class EliminationGame {

    public int lastRemaining(int n) {
        return find(n, 1, 1, true);
    }

    private int find(int n, int start, int diff, boolean left) {
        if (n == 1) { return start; }

        start = (left || n % 2 != 0) ? start + diff : start;
        return find(n / 2, start, diff * 2, !left);
    }
}