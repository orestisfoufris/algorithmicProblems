package com.leetcode.datastructures.linkedlists;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 29/12/2016.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder number1 = new StringBuilder();
        StringBuilder number2 = new StringBuilder();

        while(l1 != null) {
            number1.append(String.valueOf(l1.val));
            l1 = l1.next;
        }

        while(l2 != null) {
            number2.append(String.valueOf(l2.val));
            l2 = l2.next;
        }

        BigInteger first = new BigInteger(number1.reverse().toString());
        BigInteger second = new BigInteger(number2.reverse().toString());

        BigInteger result = first.add(second);

        if (result.compareTo(BigInteger.ZERO) == 0) {
            return new ListNode(0);
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (result.compareTo(BigInteger.ZERO) != 0) {
            temp.next = new ListNode(result.remainder(BigInteger.TEN).intValue());
            temp = temp.next;
            result = result.divide(BigInteger.TEN);
        }

        return dummy.next;
    }
}
