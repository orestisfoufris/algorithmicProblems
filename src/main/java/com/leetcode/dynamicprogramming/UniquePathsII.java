package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * 14/10/2016.
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) { return 0; }

        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }

        return find(obstacleGrid, 0, 0, dp);
    }

    private int find(int[][] grid, int x, int y, int[][] dp) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            if (grid[x][y] == 1) { return 0; }
            return 1;
        }

        if (x >= grid.length || y >= grid[0].length) {
            return 0;
        }

        if (grid[x][y] == 1) {
            return 0;
        }

        if (dp[x][y] != -1) { return dp[x][y]; }

        return dp[x][y] = find(grid, x + 1, y, dp) + find(grid, x, y + 1, dp);
    }

}
