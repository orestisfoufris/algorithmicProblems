package ctci.chapter5;

/**
 * 5.4 Write a function to determine the number of bits you would need
 * to flip convert A to integer B.
 *
 * EXAMPLE:
 *
 * Input: 29 (or: 11101), 15 (or: 01111)
 * Output: 2
 */
public final class Question5 {

    public static int countFlippedBits(int A, int B) {
        if (A == B) {
            return 0;
        }

        int xor = A ^ B; // different bits will be the number of 1s in var xor
        int count = 0;

        while (xor != 0) {
            count++;
            xor = xor & (xor - 1);
        }

        return count;
    }
}
