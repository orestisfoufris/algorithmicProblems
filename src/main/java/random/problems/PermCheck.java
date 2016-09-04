package random.problems;

import java.util.Arrays;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 *
 * The goal is to check whether array A is a permutation.
 */
public class PermCheck {

    public int solution(int[] A) {

        Arrays.sort(A);

        for (int i = 0; i < A.length; ++i) {
            if (A[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }

}
