package com.leetcode.graphs;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int x = grid.length;
        int z = grid[0].length;

        int max = 0;
        int[][] seen = new int[x][z];

        for (int i = 0; i < x; ++i) {
            for (int k = 0; k < z; ++k) {
                if (seen[i][k] != 1 && grid[i][k] == 1) {
                    max = Math.max(max, dfs(grid, i, k, seen));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int x, int y, int[][] seen) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || seen[x][y] == 1 || grid[x][y] == 0) {
            return 0;
        }

        int count = grid[x][y] == 1 ? 1 : 0;
        seen[x][y] = 1;
        return count
                + dfs(grid, x + 1, y, seen)
                + dfs(grid, x - 1, y, seen)
                + dfs(grid, x, y + 1, seen)
                + dfs(grid, x, y - 1, seen);
    }

}
