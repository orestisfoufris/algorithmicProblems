package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 03/10/2016
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2DImmutable {

    private int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; ++i) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 1; i <= matrix.length; ++i) {
            for (int j = 1; j <= matrix[0].length; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int i_min = Math.min(row1, row2);
        int i_max = Math.max(row1, row2);

        int j_min = Math.min(col1, col2);
        int j_max = Math.max(col1, col2);

        return dp[i_max + 1][j_max + 1] - dp[i_max + 1][j_min] - dp[i_min][j_max + 1] + dp[i_min][j_min];
    }

}
