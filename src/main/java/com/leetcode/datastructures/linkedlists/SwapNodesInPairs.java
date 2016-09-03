package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

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

}
