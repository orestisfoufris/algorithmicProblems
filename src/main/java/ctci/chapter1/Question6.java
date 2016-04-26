package ctci.chapter1;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixes in the image
 * is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this
 * in place?
 */
public class Question6 {

    // O(1) space
    private static int[][] rotateMatrixInPlace(int[][] input) {
        int size = input.length;
        for (int i = 0; i < input.length / 2; ++i) {
            int last = size - 1 - i;

            for (int j = i; j < last; ++j) {
                int offset = j - i;

                int temp = input[i][j];
                input[i][j] = input[last - offset][i];

                input[last - offset][i] = input[last][last - offset];

                input[last][last - offset] = input[j][last];

                input[j][last] = temp;
            }
        }

        return input;
    }

    // O(n) space
    private static int[][] rotateMatrix(int[][] input) {
        int n = input[0].length;
        int[][] rotated = new int[n][n];

        int steady = 0;
        int T = n - 1;
        while (T >= 0) {
            int moving = n - 1;
            for (int i = 0; i < n; i++) {
                rotated[steady][i] = input[moving][steady];
                moving--;
            }
            T--;
            steady++;
        }

        return rotated;
    }

    public static void main(String[] args) {

        int[][] input = {{1, 2}, {3, 4}}; // [[3, 1], [4, 2]]
        System.out.println(Arrays.deepToString(rotateMatrix(input)));
        
        int[][] input2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotateMatrix(input2))); // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

        System.out.println(Arrays.deepToString(rotateMatrixInPlace(input)));
        System.out.println(Arrays.deepToString(rotateMatrixInPlace(input2)));
    }
}
