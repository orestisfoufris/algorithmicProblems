package com.leetcode.graphs;

/**
 * https://leetcode.com/problems/word-search/
 * 12/11/2016.
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    private static boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (i == board.length || i < 0 || j < 0 || j == board[i].length || visited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        boolean found = dfs(board, word, i + 1, j, index + 1, visited) ||
                dfs(board, word, i - 1, j, index + 1, visited) ||
                dfs(board, word, i, j + 1, index + 1, visited) ||
                dfs(board, word, i, j - 1, index + 1, visited);

        visited[i][j] = false;
        return found;

    }
}
