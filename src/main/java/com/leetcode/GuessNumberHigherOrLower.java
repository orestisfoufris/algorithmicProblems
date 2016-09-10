package com.leetcode;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * The guess API is defined in the parent class GuessGame.
 * @param num, your guess
 * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
 * int guess(int num);
 * */

public class GuessNumberHigherOrLower { //extends GuessGame {

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        int middle;

        while (true) {
            middle = start + (end - start) / 2;
            int g = guess(middle);

            if (g == 1) {
                start = middle + 1;
            } else if (g == -1) {
                end = middle - 1;
            } else {
                break;
            }
        }

        return middle;
    }

    // make the class compile
    private int guess(int num) {
        return 0;
    }
}