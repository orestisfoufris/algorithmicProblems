package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * https://en.wikipedia.org/wiki/Pascal%27s_triangle
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int k = 1; k <= rowIndex; ++k) {
            result.add((int)((long) result.get(k - 1) * ((rowIndex + 1) - k) / k));
        }

        return result;
    }
}
