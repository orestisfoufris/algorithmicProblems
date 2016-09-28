package random.problems;

import java.util.Collections;
import java.util.List;

/**
 * 28/09/2016
 * Given a read only array of n + 1 integers between 1 and n,
 * find one number that repeats in linear time using less than O(n) space and
 * traversing the stream sequentially O(1) times.
 *
 * If there are multiple possible answers output any one.
 * If there is no duplicate, output -1
 */
public final class FindDuplicateInArray {

    public static int repeatedNumber(final List<Integer> a) {
        if (a.size() < 0) {
            return -1;
        }

        Collections.sort(a);

        int f = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) == f) {
                return f;
            }
            f = a.get(i);
        }

        return -1;
    }

}
