package com.leetcode.datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int number : nums) {
            if (set.contains(number)) {
                return true;
            }

            set.add(number);
        }

        return false;
    }
}
