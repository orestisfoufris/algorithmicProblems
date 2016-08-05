package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        for (int number : nums1) {
            set.add(number);
        }

        Set<Integer> result = new HashSet<>();

        for (int number : nums2) {
            if (set.contains(number)) {
                result.add(number);
            }
        }

        int[] array = new int[result.size()];
        int index = 0;
        for (Integer integer : result) {
            array[index++] = integer;
        }

        return array;
    }

}
