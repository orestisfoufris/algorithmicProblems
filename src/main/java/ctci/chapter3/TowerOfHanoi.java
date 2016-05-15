package ctci.chapter3;

import java.util.Stack;

/**
 * Solve the Tower of Hanoi problem using 3 stacks.
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi
 */
public final class TowerOfHanoi {

    // Optimal number of steps is 2^n - 1
    private static int numberOfMoves = 0;

    /**
     * Transfer all plates from the first peg to the third one.
     * Pegs are represented as stacks.
     *
     */
    public static void solve(int plates, Stack<Integer> source,
                             Stack<Integer> destination, Stack<Integer> spare) {

        if (plates == 1) {
            movePlate(source, destination);
        } else {
            solve(plates - 1, source, spare, destination);
            movePlate(source, destination);
            solve(plates - 1, spare, destination, source);
        }
    }

    private static void movePlate(Stack<Integer> from, Stack<Integer> to) {
        int val = from.pop();

        if (!to.isEmpty()) {
            assert val < to.peek() : "violated problem constraint";
        }

        to.push(val);
        numberOfMoves++;
    }

    public static void main(String[] args) throws Exception {
        Stack<Integer> source = new Stack<>();
        source.add(5);
        source.add(4);
        source.add(3);
        source.add(2);
        source.add(1);

        Stack<Integer> destination = new Stack<>();
        Stack<Integer> spare = new Stack<>();

        solve(source.size(), source, destination, spare);

        assert numberOfMoves == Math.pow(2, destination.size()) - 1;
        assert source.isEmpty();
        assert spare.isEmpty();
        assert destination.size() == 5;
    }
}
