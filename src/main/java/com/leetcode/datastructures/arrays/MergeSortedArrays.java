package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 03/10/2016.
 */
public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[n + m];
        int l = 0;
        int r = 0;

        int i = 0;
        while (l < m && r < n) {
            if (nums2[r] < nums1[l]) {
                result[i] = nums2[r++];
            } else {
                result[i] = nums1[l++];
            }

            i++;
        }

        while (l < m) {
            result[i] = nums1[l++];
            i++;
        }

        while (r < n) {
            result[i] = nums2[r++];
            i++;
        }

        System.arraycopy(result, 0, nums1, 0, result.length);
    }
}
