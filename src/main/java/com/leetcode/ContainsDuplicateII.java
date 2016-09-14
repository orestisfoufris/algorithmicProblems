package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            Integer value = map.put(nums[i], i);

            if (value != null) {
                if (Math.abs(value - i) <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}
