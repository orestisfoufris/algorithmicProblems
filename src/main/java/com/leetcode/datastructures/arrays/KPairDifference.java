package com.leetcode.datastructures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
 */
public class KPairDifference {

    public int findPairs(int[] nums, int k) {
        if (nums.length == 1 && nums[0] == k) { return 0; }
        else if (nums.length <= 1) return 0;

        int count = 0;
        int left = 0;
        int right = 1;

        Set<Set<Integer>> seen = new HashSet<>();
        Arrays.sort(nums);

        while (left < nums.length && right < nums.length) {
            if (left == right) {
                right++;
                continue;
            }

            Set<Integer> current = new HashSet<>();
            current.add(nums[left]); current.add(nums[right]);

            int diff = Math.abs(nums[left] - nums[right]);
            if (diff == k && !seen.contains(current)) {
                count++;
                seen.add(current);
            }

            if (diff >= k) left++;
            else right++;

        }

        return count;

    }


}
