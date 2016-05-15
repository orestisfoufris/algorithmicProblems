package ctci.chapter2;

/**
 * My stack implementation
 */
public class MyStack extends java.util.Stack<Integer> {

    private java.util.Stack<Integer> minimumStack = new java.util.Stack<>();
    private Integer min = Integer.MAX_VALUE;

    /**
     *
     * @return the minimum element of the stack in O(1)
     */
    public Integer findMinimum() {
        return min;
    }

    @Override
    public Integer push(Integer element) {
        super.push(element);

        if (element < min) {
            minimumStack.push(element);
            min = element;
        } else {
            minimumStack.push(min);
        }

        return element;
    }

    @Override
    public Integer pop() {
        minimumStack.pop();
        min = minimumStack.peek();

        return super.pop();
    }
}
