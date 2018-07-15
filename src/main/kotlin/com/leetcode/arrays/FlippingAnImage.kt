package com.leetcode.arrays

fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    val mask = 1

    A.forEach {
        it.reverse()
        it.forEachIndexed { index, elem ->  it[index] = elem xor mask }
    }

    return A
}