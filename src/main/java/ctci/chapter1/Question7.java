package ctci.chapter1;

import java.util.Arrays;

/**
 *
 */
public class Question7 {

    private static int[][] modifyMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            System.arraycopy(matrix[i], 0, res[i], 0, matrix[i].length);
        }


        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    helper(matrix, res, i, j);
                }
            }
        }

        return res;
    }

    private static void helper(int[][] matrix, int[][] dest, int i, int j) {
        for (int r = 0; r < matrix[0].length; ++r) {
            dest[i][r] = 0;
        }

        for (int c = 0; c < matrix.length; ++c) {
            dest[c][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 0, 9}, {5, 6, 7}};
        int[][] result = modifyMatrix(input);

        System.out.println(Arrays.deepToString(result));
    }
}
