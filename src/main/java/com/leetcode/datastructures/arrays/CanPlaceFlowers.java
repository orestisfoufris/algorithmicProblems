package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/can-place-flowers/#/description
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] zero = new int[flowerbed.length];
        int[] one = new int[flowerbed.length];

        for (int i = 0; i < zero.length; ++i) {
            zero[i] = flowerbed[i];
            one[i] = flowerbed[i];
        }

        return solve(zero, n, 0) || solve(one, n, 1);
    }

    private boolean solve(int[] flowerbed, int n, int start) {
        int count = n;

        for (int i = start; i < flowerbed.length; i += 2) {
            if (count == 0) return true;

            if (flowerbed[i] == 1) { continue; }

            boolean prev = i == 0 || flowerbed[i - 1] == 0;
            boolean next = i >= flowerbed.length - 1 || flowerbed[i + 1] == 0;

            if (prev && next) {
                flowerbed[i] = 1;
                count--;
            }
        }

        return count == 0;
    }

}
