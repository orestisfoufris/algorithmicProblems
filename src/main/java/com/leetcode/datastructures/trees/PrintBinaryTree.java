package com.leetcode.datastructures.trees;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/print-binary-tree/description/
 */
public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {

        List<List<String>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int height = findHeight(root);
        int size = ((int) Math.pow(2, height) - 1);

        String[][] ar = new String[height][size];
        for (String[] x : ar) Arrays.fill(x, "");

        traverse(root, ar, 0, 0, size);

        for (int i = 0; i < ar.length; ++i) {
            result.add(new ArrayList<>());
            for (int k = 0; k < ar[i].length; ++k) {
                result.get(i).add(ar[i][k]);
            }
        }

        return result;
    }

    private void traverse(TreeNode node, String[][] ar, int row, int start, int end) {
        if (node != null) {
            int mid = start + (end - start) / 2;
            ar[row][mid] = String.valueOf(node.val);
            traverse(node.left, ar, row + 1, start, mid);
            traverse(node.right, ar, row + 1, mid + 1, end);
        }
    }

    private int findHeight(TreeNode node) {
        if (node == null) { return 0; }
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }

}
