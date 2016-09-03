package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode result;
        if (l1.val <= l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }

        ListNode head = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val ) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }

            result = result.next;
        }

        // copy the rest
        while (l1 != null) {
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }

        while (l2 != null) {
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }

        return head;
    }

}
