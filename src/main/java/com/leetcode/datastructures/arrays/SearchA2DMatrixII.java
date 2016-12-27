package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 27/12/2016.
 */
public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        return findRowColumn(matrix, target, 0, matrix[0].length - 1);
    }

    private boolean findRowColumn(int[][] matrix, int target, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }

        int last= matrix[x][y];

        if (last == target) {
            return true;
        }

        if (target < last) { // then it can't be on that column
            return findRowColumn(matrix, target, x, y - 1);
        } else if (target > last) { // then it can't be that row
            return findRowColumn(matrix, target, x + 1, y);
        }

        return false;
    }

}
