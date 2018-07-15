package com.leetcode.strings


fun toLowerCase(str: String): String {
    return String(str.map { it.toLowerCase() }.toCharArray())
}
