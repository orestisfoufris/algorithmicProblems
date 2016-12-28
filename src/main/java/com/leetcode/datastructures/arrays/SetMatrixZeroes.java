package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 28/12/2016.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean isFirstColumnZero = false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
            }

            for (int j = 1; j < columns; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; --i) {
            for (int j = columns - 1; j >= 1; --j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (isFirstColumnZero) {
                matrix[i][0] = 0;
            }
        }
    }

}
