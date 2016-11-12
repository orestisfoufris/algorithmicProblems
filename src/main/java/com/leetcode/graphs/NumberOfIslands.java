package com.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

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


    public static int numIslandsBfs(char[][] grid) {
        int counter = 0;

        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[x].length; ++y) {
                if (grid[x][y] == '1') {
                    counter++;
                    bfs(grid, x, y);
                }
            }
        }

        return counter;
    }

    private static void bfs(char[][] grid, int x, int y) {

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        grid[x][y] = '0';

        while (!q.isEmpty()) {
            Point p = q.poll();

            if(p.x > 0 && grid[p.x - 1][p.y] == '1') {
                q.offer(new Point(p.x - 1, p.y));
                grid[p.x - 1][p.y] = '0';
            }

            if (p.x < grid.length - 1 && grid[p.x + 1][p.y] == '1') {
                q.offer(new Point(p.x + 1, p.y));
                grid[p.x + 1][p.y] = '0';
            }

            if (p.y > 0 && grid[p.x][p.y - 1] == '1') {
                q.offer(new Point(p.x, p.y - 1));
                grid[p.x][p.y - 1] = '0';
            }

            if (p.y < grid[0].length - 1 && grid[p.x][p.y + 1] == '1') {
                q.offer(new Point(p.x, p.y + 1));
                grid[p.x][p.y + 1] = '0';
            }
        }
    }

    private static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
