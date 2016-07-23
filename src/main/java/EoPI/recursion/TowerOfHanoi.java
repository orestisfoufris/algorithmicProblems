package EoPI.recursion;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 16.1
 */
public final class TowerOfHanoi {

    static void printSequenceOfOperations(int numOfPlates, Deque<Integer> source,
                                                 Deque<Integer> destination, Deque<Integer> temp) {
        if (numOfPlates == 1) {
            System.out.println("Moving from " + source + " to " + destination);
            destination.addFirst(source.removeFirst());

        } else {
            printSequenceOfOperations(numOfPlates - 1, source, temp, destination);
            System.out.println("Moving from " + source + " to " + destination);
            destination.addFirst(source.removeFirst());
            printSequenceOfOperations(numOfPlates - 1, temp, destination, source);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> source = new LinkedList<>();
        Deque<Integer> destination = new LinkedList<>();
        Deque<Integer> temp = new LinkedList<>();
        source.add(1);
        source.add(2);
        source.add(3);

        printSequenceOfOperations(source.size(), source, destination, temp);
        System.out.println(destination);
    }
}
