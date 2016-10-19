package com.leetcode.datastructures.trees;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 19/10/2016.
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        link(root);
    }

    private void link(TreeLinkNode node) {
        if (node != null) {
            TreeLinkNode tmp = node;

            while (node != null) {
                if (node.left != null) {
                    node.left.next = node.right;
                }

                if (node.next != null) {
                    if (node.right != null) {
                        node.right.next = node.next.left;
                    }
                }

                node = node.next;
            }

            link(tmp.left);
        }
    }


    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

}
