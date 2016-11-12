package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * 12/11/2016.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode even = head.next;
        ListNode evenStart = head.next;
        ListNode odd = head;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenStart;

        return head;
    }

    public ListNode oddEvenListComplicated(ListNode head) {
        if (head == null) { return null; }
        ListNode odd = head;
        ListNode even = null;
        ListNode start = null;
        ListNode prev;

        if (head.next == null) {
            return head;
        }

        while (odd != null) {
            ListNode tmp = odd.next;

            if (even == null) {
                even = tmp;
                start = even;
            } else {
                even.next = tmp;
                even = even.next;
            }

            if (odd.next != null) {
                odd.next = odd.next.next;
                prev = odd;
                odd = odd.next;
                if (odd != null && odd.next == null) {
                    even.next = null;
                    odd.next = start;
                    break;
                } else if (odd == null) {
                    even.next = null;
                    prev.next = start;
                }
            }
        }

        return head;

    }

}
