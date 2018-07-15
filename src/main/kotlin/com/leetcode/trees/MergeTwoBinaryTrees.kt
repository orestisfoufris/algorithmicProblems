package com.leetcode.trees

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null && t2 == null) return null

    val node = merge(t1, t2)

    node?.left = mergeTrees(t1?.left, t2?.left)
    node?.right = mergeTrees(t1?.right, t2?.right)

    return node
}

private fun merge(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null && t2 == null) return null

    return TreeNode((t1?.`val` ?: 0) + (t2?.`val` ?: 0))
}