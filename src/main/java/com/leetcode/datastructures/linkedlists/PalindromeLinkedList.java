package com.leetcode.datastructures.linkedlists;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 29/10/2016.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (prev.val != slow.val) {
                return false;
            }

            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

}
