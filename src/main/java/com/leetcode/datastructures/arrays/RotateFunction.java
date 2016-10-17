package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/rotate-function/
 * 17/10/2016.
 */
public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int prevRotationSum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            prevRotationSum += i * A[i];
        }

        int max = prevRotationSum;

        for (int i = A.length -1; i > 0; i--){
            prevRotationSum += sum - A.length * A[i];
            max = Math.max(prevRotationSum, max);
        }

        return max;
    }

}
