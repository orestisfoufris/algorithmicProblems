package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 * 23/10/2016.
 */
public class BattleshipsInABoard {

    public static int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if ( (i - 1 < 0 && j - 1 < 0) && board[i][j] == 'X') {
                    count++;
                } else if (i - 1 >= 0 || j - 1 >= 0) {
                    if ((i - 1 >= 0 && j - 1 < 0) && (board[i - 1][j] != 'X' && board[i][j] == 'X')) {
                        count++;
                    } else if ((i - 1 < 0 && j - 1 >= 0) && board[i][j - 1] != 'X' && board[i][j] == 'X') {
                        count++;
                    } else if ((i - 1 >= 0 && j - 1 >= 0) && board[i - 1][j] != 'X' && board[i][j - 1] != 'X' && board[i][j] == 'X') {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
