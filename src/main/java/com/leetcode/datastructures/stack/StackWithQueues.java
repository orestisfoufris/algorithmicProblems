package com.leetcode.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 11/11/2016.
 */
class StackWithQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private Integer last = null;

    public void push(int x) {
        if (q1.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }

        last = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (q1.isEmpty()) {
            transfer(q2, q1, q2.size());
            q2.poll();
        } else {
            transfer(q1, q2, q1.size());
            q1.poll();
        }
    }

    // Get the top element.
    public int top() {
        return last;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    private void transfer(Queue<Integer> from, Queue<Integer> to, int size) {
        for (int i = 0; i < size - 1; ++i) {
            int f = from.poll();
            last = f;
            to.offer(f);
        }
    }
}