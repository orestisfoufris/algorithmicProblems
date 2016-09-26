package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/unique-paths/
 * @author Orestis 26/09/2016.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return find(m, n, dp);
    }

    private int find(int rows, int columns, int[][] dp) {
        if (rows == 1 || columns == 1) {
            return 1;
        }

        if (rows < 0 || columns < 0) {
            return 0;
        }

        if (dp[rows][columns] != 0) {
            return dp[rows][columns];
        }

        int res = find(rows - 1, columns, dp) + find(rows, columns - 1, dp);
        dp[rows][columns] = res;

        return res;
    }

}
