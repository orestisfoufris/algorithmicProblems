package com.leetcode.trees

class FindLeavesOfBinaryTree {

    private val res: MutableList<List<Int>> = mutableListOf()

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        if (root == null) return mutableListOf()

        res.add(t(root))
        res.addAll(findLeaves(root.left).toMutableList())
        res.addAll(findLeaves(root.right).toMutableList())

        return res
    }

    private fun t(r: TreeNode?): List<Int> {
        if (r == null) return emptyList()

        return if (r.left == null && r.right == null) {
            listOf(r.`val`)
        } else {
            val res = t(r.left) + t(r.right)
            r.left = null
            r.right = null
            res
        }
    }

}