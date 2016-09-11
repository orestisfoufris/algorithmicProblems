package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    //one pass answer
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null) {
            if (n <= 0) {
                slow = slow.next;
            } else {
                n--;
            }

            fast = fast.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

    // two passes
    public ListNode removeNthFromEndTwoPasses(ListNode head, int n) {
        ListNode tmp = head;
        int size = 1;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        n = size - n;

        ListNode h = head;
        ListNode prev = null;
        int counter = 1;

        while(h != null) {
            if (counter == n) {
                if (prev == null) {
                    head = head.next;
                    break;
                } else {
                    prev.next = h.next;
                    break;
                }
            } else {
                prev = h;
                h = h.next;
                counter++;
            }
        }

        return head;
    }
}
