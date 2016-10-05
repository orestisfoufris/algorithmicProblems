package com.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * 04/10/2016.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pair=new HashMap<>();
        int result[] = new int[2];

        for (int i = 0; i < nums.length; ++i){
            if (pair.containsKey(nums[i])) {
                result[0] = pair.get(nums[i]);
                result[1] = i;
                return result;
            }
            else {
                pair.put(target - nums[i], i);
            }
        }

        return result;
    }
}
