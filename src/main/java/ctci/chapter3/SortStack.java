package ctci.chapter3;

import java.util.Stack;

/**
 * 3.6 Write a program to sort a stack in ascending order. You may use
 * at most one additional stack to hold items, but you may not copy the elements
 * into any other data structure(such an array). The stack supports the following
 * operations: pop(), push(), peek, isEmpty.
 */
public final class SortStack {


    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            Integer tempValue = stack.pop();

            if (!temp.isEmpty()) {
                if (tempValue > temp.peek()) {
                    temp.push(tempValue);
                } else {
                    while (!temp.isEmpty() && tempValue < temp.peek()) {
                        stack.push(temp.pop());
                    }
                    temp.push(tempValue);
                }
            } else {
                temp.push(tempValue);
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(6);
        stack.push(12);
        stack.push(8);
        stack.push(5);

        System.out.println(SortStack.sort(stack));
    }
}
