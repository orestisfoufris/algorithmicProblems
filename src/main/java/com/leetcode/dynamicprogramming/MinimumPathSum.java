package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) continue;

                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }

            }
        }

        return grid[m - 1][n - 1];
    }

    public int minPathSumTopDown(int[][] grid) {
        int[][] computed = new int[grid.length + 1][grid[0].length + 1];
        for (int[] ar : computed) {
            Arrays.fill(ar, -1);
        }

        return solve(grid, 0, 0, computed);
    }

    private int solve(int[][] g, int i, int j, int[][] computed) {
        if (i == g.length - 1 && j == g[i].length - 1) {
            return g[i][j];
        }

        if (i >= g.length || j >= g[i].length) {
            return Integer.MAX_VALUE;
        }

        if (computed[i][j] != -1) {
            return computed[i][j];
        }

        int result = g[i][j] + Math.min(solve(g, i + 1, j, computed),
                                        solve(g, i, j + 1, computed));

        return computed[i][j] = result;
    }

}
