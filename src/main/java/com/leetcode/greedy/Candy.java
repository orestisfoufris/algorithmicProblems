package com.leetcode.greedy;

/**
 * https://leetcode.com/problems/candy/
 * 13/11/2016.
 */
public class Candy {

    public int candy(int[] ratings) {

        int n = ratings.length;
        if (n == 1) {
            return 1;
        }

        int[] c = new int[n];

        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                c[i] = c[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                c[i] = Math.max(c[i], c[i + 1] + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += c[i];
        }

        return count + n;
    }

}
