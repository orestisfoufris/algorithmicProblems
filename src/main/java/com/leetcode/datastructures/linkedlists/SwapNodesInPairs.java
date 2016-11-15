package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    // 4ms
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next ==  null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null) {
            int prev = slow.val;
            slow.val = fast.val;
            fast.val = prev;

            if (fast.next != null) {
                slow = fast.next;
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }

        return head;
    }

    // 5ms
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head.next;
        ListNode prev = null;

        while (head != null && head.next != null) {
            prev = head;

            ListNode third = head.next.next;
            ListNode second = head.next;

            second.next = head;
            head.next = third;
            head = head.next;

            if (head != null) {
                prev.next = head.next;
            }
        }

        if (head != null) {
            prev.next = head;
        }

        return start;
    }

    // 6ms
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;
        ListNode third = second.next;

        second.next = head;
        head.next = swapPairsRecursive(third);

        return second;
    }

}
