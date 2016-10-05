package com.leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 05/10/2016.
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int i : nums) {
                if (i <= mid) {
                    count++;
                }
                if (count > mid) {
                    break;
                }
            }

            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
