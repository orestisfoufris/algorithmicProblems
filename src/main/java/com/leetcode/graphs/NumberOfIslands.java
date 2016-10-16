package com.leetcode.graphs;

/**
 * https://leetcode.com/problems/number-of-islands/
 * 16/10/2016.
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int result = 0;

        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[0].length; ++y) {
                if (grid[x][y] == '1') {
                    result += 1;
                    dfs(grid, x, y);
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] matrix, int x, int y) {
        if (matrix[x][y] == '1') {

            matrix[x][y] = 0; // mark visited
            if (x + 1 != matrix.length) {
                dfs(matrix, x + 1, y);
            }

            if (y + 1 != matrix[0].length) {
                dfs(matrix, x, y + 1);
            }

            if (x - 1 >= 0) {
                dfs(matrix, x - 1, y);
            }

            if (y - 1 >= 0) {
                dfs(matrix, x, y - 1);
            }
        }
    }

}
