package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/linked-list-cycle
 */

public class DetectCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (fast == slow) {
                return true;
            }

            slow = slow.next;

            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;
        }

        return false;
    }

}
