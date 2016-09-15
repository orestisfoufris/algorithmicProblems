package com.leetcode.datastructures.linkedlists;

class ListNode {
    protected int val;
    protected ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode {" +
                " val= " + val +
                ", next= " + next +
                "} ";
    }
}
