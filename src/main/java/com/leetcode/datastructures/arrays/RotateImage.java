package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 * 29/12/2016.
 */
public class RotateImage {


    public void rotateExtraSpace(int[][] matrix) {
        int len = matrix.length;
        int[][] result = new int[len][len];

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                result[len - j - 1][len - i - 1] = matrix[i][len - j - 1];
            }
        }

        for (int i = 0; i < len; ++i) {
            System.arraycopy(result[i], 0, matrix[i], 0, len);
        }
    }

    // in-place
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len / 2; ++i) {
            int last = len - i - 1;

            for (int j = i; j < last; ++j) {
                int offset = j - i;
                int top = matrix[i][j];

                matrix[i][j] = matrix[last - offset][i];
                matrix[last - offset][i] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[j][last];
                matrix[j][last] = top;
            }
        }
    }
}
