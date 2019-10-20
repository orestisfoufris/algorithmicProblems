package com.leetcode.datastructures.arrays;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                result[even] = A[i];
                even += 2;
            } else {
                result[odd] = A[i];
                odd += 2;
            }
        }

        return result;
    }
}
