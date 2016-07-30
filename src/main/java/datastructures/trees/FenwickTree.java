package datastructures.trees;

/**
 * A Fenwick Tree implementation for finding
 * range sum queries in O(logn).
 *
 * Note: update() modifies the original array
 */
public class FenwickTree {

    private int[] sumArray;
    private int[] original;

    FenwickTree(int[] array) {
        this.original = array;

        this.sumArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            updateTree(i, array[i]);
        }
    }

    int getSum(int from, int to) {

        if (from == 0) {
            return getSumFromStart(to);
        }

        return getSumFromStart(to) - getSumFromStart(from - 1);
    }

    private int getSumFromStart(int index) {
        int sum = 0;
        index++;

        while (index > 0) {
            sum += sumArray[index];

            index -= findAncestor(index);
        }

        return sum;
    }

    void update(int index, int val) {
        int diff = val - original[index];

        if (diff == 0) {
            return;
        }

        original[index] = val;
        updateTree(index, diff);
    }

    private void updateTree(int index, int value) {
        index++;

        // traverse all ancestors and add @param value
        while (index < sumArray.length) {
            sumArray[index] += value;

            // find parent
            index += findAncestor(index);
        }
    }

    private int findAncestor(int index) {
        return index & (-index); // get the last set bit from index
    }
}
