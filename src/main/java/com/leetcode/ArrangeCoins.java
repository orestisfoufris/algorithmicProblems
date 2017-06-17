package com.leetcode;

/**
 * https://leetcode.com/problems/arranging-coins/
 * 11/11/2016.
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int count = 0;

        for (int i = 1; i <= n; ++i) {
            if (n - i >= 0) {
                count++;
            }
            n = n - i;
        }

        return count;
    }

    public int arrangeCoinsBinarySearch(int n) {
        int end = n;
        int start = 0;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            double sum = findSum(mid, n);

            if (sum > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start - 1;
    }

    // arithmetic series
    private double findSum(int mid, int n) {
        return mid * ((1 + mid) / 2.0);
    }
}
