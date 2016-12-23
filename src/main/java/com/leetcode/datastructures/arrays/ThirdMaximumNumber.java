package com.leetcode.datastructures.arrays;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/third-maximum-number/
 * 23/12/2016.
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int num : nums) {
            set.add(num);
            if(set.size() > 3) {
                set.remove(set.first());
            }
        }

        return set.size() < 3 ? set.last() : set.first();
    }
}
