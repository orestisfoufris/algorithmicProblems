package com.hackerrank.datastructures.arrays;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */
public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;

        for (; i < arr.length; ++i) {
            if (arr[i] == i + 1) continue;
            s(arr, i, arr[i] - 1);
            swaps++;
            i--; // since we found a misplaced element let's stay on the same index 'till it has the right value
        }

        return swaps;
    }

    private static void s(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
