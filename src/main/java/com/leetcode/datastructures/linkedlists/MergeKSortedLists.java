package com.leetcode.datastructures.linkedlists;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 28/12/2016.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, (l1, l2) -> {
            if (l1.val > l2.val) {
                return 1;
            } else if (l2.val > l1.val) {
                return -1;
            } else {
                return 0;
            }
        }) ;

        ListNode dummy = new ListNode(-1);
        ListNode last = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            last.next=queue.poll();
            last = last.next;

            if (last.next != null) {
                queue.add(last.next);
            }
        }

        return dummy.next;
    }


    public ListNode mergeKListsRecursive(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }


    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int middle = start + ((end - start) / 2);

            ListNode l1 = partition(lists, start, middle);
            ListNode l2 = partition(lists, middle + 1, end);

            return merge(l1, l2);
        } else {
            return null;
        }
    }


    public static ListNode merge(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = merge(l1.next,l2);
            return l1;
        } else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }

}
