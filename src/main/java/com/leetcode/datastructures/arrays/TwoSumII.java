package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while(low < high) {
            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[]{low + 1,high + 1};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }

        return new int[]{-1,-1};
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; ++i) {
            int start = i + 1;
            int end = numbers.length - 1;
            int diff = target - numbers[i];

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (numbers[mid] == diff) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                } else if (numbers[mid] < diff) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return res;
    }

}
