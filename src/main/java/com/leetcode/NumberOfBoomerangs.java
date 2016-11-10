package com.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 * 09/11/2016.
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] p) {
        int count = 0;

        for (int i = 0; i < p.length; ++i) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < p.length; ++j) {
                if (i == j) continue;

                int x1 = p[i][0];
                int y1 = p[i][1];

                int x2 = p[j][0];
                int y2 = p[j][1];

                int distance = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

                int value = map.merge(distance, 0, NumberOfBoomerangs::increment);
                count += value * 2;

            }
        }

        return count;
    }

    private static Integer increment(Integer a, Integer b) {
        return a + b + 1;
    }

}
