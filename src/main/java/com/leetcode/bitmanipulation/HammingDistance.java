package com.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/hamming-distance/
 * 20/12/2016.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int mask = 1;
        int count = 0;

        for (int i = 0; i < 32; ++i) {
            boolean a = (mask & x) > 0;
            boolean b = (mask & y) > 0;

            if (a != b) {
                count++;
            }

            mask = mask << 1;
        }

        return count;
    }

}
