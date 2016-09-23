package EoPI.recursion;

import java.util.List;
import java.util.ArrayList;

/**
 *  16.4 Generate the power set of a given set
 */
public class GeneratePowerSet {

    static List<List<Integer>> generatePowerSet(List<Integer> given) {
        List<List<Integer>> powerSet = new ArrayList<>();

        for (int i = 0; i < (1 << given.size()); ++i) {

            int mask = i;
            List<Integer> subset = new ArrayList<>();

            while (mask != 0) {
                subset.add(given.get((int) (Math.log(mask & ~(mask - 1)) / Math.log(2))));
                mask &= mask - 1;
            }

            powerSet.add(subset);
        }

        return powerSet;
    }

    public static void main(String[] args) {
        List<Integer> given = new ArrayList<>();
        given.add(0);
        given.add(1);
        given.add(2);
        given.add(5);

        System.out.println(GeneratePowerSet.generatePowerSet(given));
    }
}
