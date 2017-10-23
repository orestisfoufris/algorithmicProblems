package com.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/#/description
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int pivot = findNonIncreasingSeq(nums);

        if (pivot <= -1) {
            Arrays.sort(nums);
            return;
        }

        int successor = findSuccessorIndex(pivot, nums);
        swap(pivot, successor, nums);
        reverseSuffix(pivot + 1, nums);
    }


    private void reverseSuffix(int start, int[] nums) {
        int end = nums.length - 1;
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    private int findSuccessorIndex(int end, int[] nums) {
        int index = nums.length -1;

        for (int i = nums.length - 1; i > end; --i) {
            if (nums[i] > nums[end]) {
                index = i;
                break;
            }
        }

        return index;
    }

    // find longest non increasing sequence
    private int findNonIncreasingSeq(int[] nums) {
        int index = nums.length - 1;
        int prev = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < prev) {
                break;
            }
            prev = nums[i];
            index--;
        }

        return --index;
    }

    private void swap(int pivot, int successor, int[] nums) {
        int temp = nums[pivot];
        nums[pivot] = nums[successor];
        nums[successor] = temp;
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        //int[] a = new int[] {1, 3, 2}; //returns [3, 2, 1] but it should be [2, 1, 3]
        int[] a = new int[] {3, 2, 1};
        n.nextPermutation(a);

        System.out.println(Arrays.toString(a));
    }

}
