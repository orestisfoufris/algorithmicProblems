package com.leetcode.datastructures.arrays;

import java.util.List;

/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/#/description
 * 02/07/17.
 */
public class MaxDistance {

    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> f = arrays.get(0);
        int min = f.get(0);
        int max = f.get(f.size() - 1);

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < arrays.size(); ++i) {
            List<Integer> c = arrays.get(i);
            int c_max = c.get(c.size() - 1);
            int c_min = c.get(0);

            result = Math.max(result, Math.abs(c_max - min));
            result = Math.max(result, Math.abs(max - c_min));

            min = Math.min(min, c_min);
            max = Math.max(max, c_max);
        }

        return result;
    }

}
