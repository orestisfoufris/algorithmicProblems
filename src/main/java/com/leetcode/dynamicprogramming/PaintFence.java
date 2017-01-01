package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/paint-fence/
 * 01/01/2017.
 */
public class PaintFence {

    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        } else if (n == 1) {
            return k;
        }

        int[] sameColor = new int[n];
        int[] diffColor = new int[n];

        sameColor[0] = 0;
        diffColor[0] = k;

        for (int i = 1; i < n; i++) {
            sameColor[i] = diffColor[i - 1];
            diffColor[i] = (sameColor[i - 1] + diffColor[i - 1]) * (k - 1);
        }

        return sameColor[n - 1] + diffColor[n - 1];
    }
}
