package com.leetcode.datastructures.trees;


public class ConvertBSTToGreaterTree {
    private int count = 0;
    private int prev = 0;

    public TreeNode convertBST(TreeNode root) {
      if (root == null) {
        return null;
      }

      traverse(root);
      traverseAndSubtract(root);

      return root;
    }

    private void traverseAndSubtract(TreeNode node){
      if (node != null) {
        traverseAndSubtract(node.left);
        int temp = node.val;
        node.val = count - prev;
        prev += temp;
        traverseAndSubtract(node.right);
      }
    }

    private void traverse(TreeNode node){
      if (node != null) {
        count += node.val;
        traverse(node.right);
        traverse(node.left);
      }
    }
}
