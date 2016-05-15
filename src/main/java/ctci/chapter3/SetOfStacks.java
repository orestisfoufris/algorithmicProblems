package ctci.chapter3;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 3.3 Imagine a literal stack of plates.
 * If the stack gets too high, it might topple. Therefore,
 * in real life, we would likely start a new stack when the previous
 * stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 */
public class SetOfStacks {
    private final List<Stack<Integer>> stacks = new ArrayList<>();
    private final int THRESHOLD;
    private int currentStack = 0;

    public SetOfStacks(int threshold) {
        THRESHOLD = threshold;
        stacks.add(new Stack<>());
    }

    /**
     *
     * @param element to be pushed on one of the stacks. If current stack has riched
     *                its limits then create and add it on a new stack.
     * @return element
     */
    public Integer push(Integer element) {
        if (currentStack < 0) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(element);
            currentStack++;
            stacks.add(newStack);

        } else {
            if (stacks.get(currentStack).size() == THRESHOLD) {
                currentStack++;
                Stack<Integer> newStack = new Stack<>();
                newStack.push(element);
                stacks.add(newStack);
            } else {
                stacks.get(currentStack).push(element);
            }
        }

        return element;
    }

    /**
     * Remove an element from the current stack
     * @return head of stack
     */
    public Integer pop() {
        return pop(currentStack);
    }

    public Integer pop(Integer stackNumber) {
        if (stacks.isEmpty() || stackNumber >= stacks.size()){
            return null;
        }

        Stack<Integer> current = stacks.get(stackNumber);
        Integer value = stacks.get(stackNumber).pop();

        if (current.isEmpty()) {
            stacks.remove(current);
            currentStack--;
        }

        return value;
    }

    @VisibleForTesting
    public List<Stack<Integer>> getStacks() {
        return stacks;
    }
}
