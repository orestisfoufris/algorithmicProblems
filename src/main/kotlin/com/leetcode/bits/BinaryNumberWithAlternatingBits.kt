package com.leetcode.bits

fun hasAlternatingBits(n: Int): Boolean {
    val s = Integer.toBinaryString(n)
    return !(1 until s.length).any { (s[it] == s[it - 1]) }
}