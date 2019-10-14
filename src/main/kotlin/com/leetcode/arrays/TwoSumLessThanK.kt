package com.leetcode.arrays

import java.lang.Integer.max

/**
 * https://leetcode.com/problems/two-sum-less-than-k/
 */
fun twoSumLessThanK(A: IntArray, K: Int): Int {
    A.sort()
    return solve(A, K)
}


fun solve(A: IntArray, K: Int): Int {
    if (A.isEmpty() || A.size == 1) return -1
    val sum =  A[0] + A[A.size - 1]

    return if (sum >= K) solve(A.sliceArray(0 until A.size - 1), K)
           else max(sum, solve(A.sliceArray(1 until A.size), K))
}