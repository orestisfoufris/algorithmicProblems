package ctci.chapter3;

import java.util.Stack;

/**
 * Implement a queue using two stacks
 */
public class MyQueue {

    private Stack<Integer> firstStack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();

    public Integer deQueue() {
        if (firstStack.isEmpty() && secondStack.isEmpty()) {
            return null;
        }

        if (secondStack.isEmpty()) {
            shiftElements(firstStack, secondStack);
        }

        return secondStack.pop();
    }

    public void enQueue(Integer element) {
        firstStack.push(element);
    }

    private Stack<Integer> shiftElements(Stack<Integer> from, Stack<Integer> to) {
        while(!from.isEmpty()) {
           to.push(from.pop());
        }

        return to;
    }

    public int size() {
        return firstStack.size() + secondStack.size();
    }
}
