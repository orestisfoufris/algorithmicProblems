package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/sort-list/
 * 17/11/2016.
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) { return second; }
        if (second == null) { return first; }

        if (first.val > second.val) {
            second.next = merge(first, second.next);
            return second;
        } else {
            first.next = merge(first.next, second);
            return first;
        }
    }

}
