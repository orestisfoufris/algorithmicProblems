package com.leetcode;

/**
 * https://leetcode.com/problems/beautiful-arrangement/description/
 */
public class BeautifulArrangement {
    private int count = 0;

    public int countArrangement(int N) {
        if (N == 0) {
            return N;
        }

        int[] array = new int[N + 1];

        for (int i = 0; i <= N; ++i) {
            array[i] = i;
        }

        backtrack(1, array);

        return count;

    }

    private void backtrack(int start, int[] nums) {
        if (start == nums.length) {
            count++;
            return;
        }

        for (int i = start; i < nums.length; ++i) {
            swap(i, start, nums);
            if (nums[start] % start == 0 || start % nums[start] == 0) {
                backtrack(start + 1, nums);
            }
            swap(start, i, nums);
        }

    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
