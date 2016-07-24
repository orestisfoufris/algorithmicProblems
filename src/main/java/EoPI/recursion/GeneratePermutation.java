package EoPI.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * 16.3 Find all permutation of an array
 */
public final class GeneratePermutation {

    private static int countPermutations = 0;

    static List<List<Integer>> findPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(0, array, result);

        return result;
    }

    private static void findPermutations(int start, List<Integer> array, List<List<Integer>> result) {
        if (start == array.size()) {
            result.add(new ArrayList<>(array));
            countPermutations++;
        }

        for (int i = start; i < array.size(); ++i) {
            Collections.swap(array, start, i);
            findPermutations(start + 1, array, result);
            Collections.swap(array, i, start);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findPermutations(newArrayList(2, 3, 5, 7));
        System.out.println(result);
        System.out.println(countPermutations);
    }
}
