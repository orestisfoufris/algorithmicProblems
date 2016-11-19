package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 19/11/2016.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) { return null; }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }

        return null;
    }

}
