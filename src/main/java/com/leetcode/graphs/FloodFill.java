package com.leetcode.graphs;

/**
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] seen = new int[image.length][image[sr].length];
        dfs(image, sr, sc, newColor, seen, image[sr][sc]);

        return image;
    }

    private void dfs(int[][] image, int row, int column, int color, int[][] seen, int start) {
        if (row >= image.length || row < 0 || column >= image[row].length || column < 0) { return; }
        if (seen[row][column] == 1) { return; }

        if (image[row][column] != start) { return; }

        image[row][column] = color;
        seen[row][column] = 1;

        dfs(image, row + 1, column, color, seen, start);
        dfs(image, row - 1, column, color, seen, start);
        dfs(image, row, column + 1, color, seen, start);
        dfs(image, row, column - 1, color, seen, start);

    }
}
