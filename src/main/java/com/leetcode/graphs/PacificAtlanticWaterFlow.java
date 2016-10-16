package com.leetcode.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * 16/10/2016.
 */
public class PacificAtlanticWaterFlow {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int n = matrix.length;

        if (n == 0) {
            return result;
        }

        int m = matrix[0].length;

        int[][] state = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            state[i][0] |= 1; // touches Pacific

            if (i == n - 1 || m == 1) { // touches Atlantic
                state[i][0] |= 2;
            }

            if (state[i][0] == 3) { // touches both Oceans
                result.add(new int[]{i, 0});
            }

            queue.add(new int[]{i, 0});

            if (m > 1) {
                state[i][m - 1] |= 2; // touches Atlantic
                if (i == 0) {
                    state[i][m - 1] |= 1; // touches Pacific as it is on the top row
                }

                if (state[i][m - 1] == 3) { // touches both
                    result.add(new int[]{i, m - 1});
                }
                queue.add(new int[]{i, m - 1});
            }
        }

        for (int j = 1; j < m - 1; j++) {
            state[0][j] |= 1; // they all touches Pacific
            if (n == 1) { // if we only have one column they also touch Atlantic
                state[0][j] |= 2;
            }
            if (state[0][j] == 3) { // touches both, add it to the result
                result.add(new int[]{0, j});
            }
            queue.add(new int[]{0, j});

            if (n > 1) {
                state[n - 1][j] |= 2; // touches Atlantic as it is on the last row
                if (state[n - 1][j] == 3) {
                    result.add(new int[]{n - 1, j});
                }
                queue.add(new int[]{n - 1, j});
            }
        }

        // directions:  above,  below,    left,   right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] direction : dirs) {
                int row = point[0] + direction[0];
                int col = point[1] + direction[1];
                // look for invadid points
                if (row < 0 || col < 0 || row == n || col == m || // outside borders
                        matrix[row][col] < matrix[point[0]][point[1]] || // cant flow from lower height
                        ((state[point[0]][point[1]] | state[row][col]) == state[row][col])) {
                    continue;
                }

                state[row][col] |= state[point[0]][point[1]];
                if (state[row][col] == 3) {
                    result.add(new int[]{row, col});
                }
                queue.add(new int[]{row, col});
            }
        }

        return result;
    }
}
