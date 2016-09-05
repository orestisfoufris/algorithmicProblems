package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i = 1; i < numRows; ++i) {
            result.add(createRow(result.get(i - 1)));
        }

        return result;
    }

    private List<Integer> createRow(List<Integer> prev) {
        List<Integer> list = new ArrayList<>(); list.add(1);
        int slow = 0;
        int fast = 1;

        for (int i = 0; i < prev.size() - 1; ++i) {
            list.add(prev.get(slow) + prev.get(fast));
            slow++; fast++;
        }

        list.add(1);
        return list;
    }
}
