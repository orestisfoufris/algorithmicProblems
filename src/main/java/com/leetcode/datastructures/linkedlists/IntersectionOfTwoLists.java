package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode b = headB == null ? null : headB;
        ListNode a = headA == null ? null : headA;

        if (a == null || b == null) {
            return null;
        }

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
