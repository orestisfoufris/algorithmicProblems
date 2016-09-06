package com.leetcode.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {
    private Deque<Integer> first = new ArrayDeque<>();
    private Deque<Integer> second = new ArrayDeque<>();

    // Push element x to the back of queue.
    public void push(int x) {
        first.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (second.isEmpty() && !first.isEmpty()) {
            transfer(first, second);
        }

        second.pop();
    }

    // Get the front element.
    public int peek() {
        if (second.isEmpty() && !first.isEmpty()) {
            transfer(first, second);
        }

        return second.peek();

    }

    // Return whether the queue is empty.
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }

    private void transfer(Deque<Integer> from, Deque<Integer> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
