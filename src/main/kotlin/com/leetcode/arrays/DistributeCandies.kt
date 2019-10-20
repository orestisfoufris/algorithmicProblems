package com.leetcode.arrays

/**
 * https://leetcode.com/problems/distribute-candies/
 */
fun distributeCandies(candies: IntArray): Int {
    val c = candies.size / 2
    val diff = candies.toSet().size
    return if (diff >= c) c else diff
}