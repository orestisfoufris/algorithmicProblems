package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (start < end) {
            int minHeight = Math.min(height[start], height[end]);
            int area = minHeight * (end - start);
            max = Math.max(max, area);

            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }

        return max;
    }

}
