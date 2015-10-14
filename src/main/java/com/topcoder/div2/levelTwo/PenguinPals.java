package com.topcoder.div2.levelTwo;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Orestis 14/10/2015.
 * problem statement : http://community.topcoder.com/stat?c=problem_statement&pm=12355&rd=15486
 */

public class PenguinPals {

    // Greedy approach
    public static int findMaximumMatching(String colors) {
        int count = 0;
        List<String> pengColors = newArrayList(Arrays.asList(colors.split("(?!^)")));

        if (pengColors.size() == 0) {
            return count;
        }

        int size = pengColors.size();
        for (int i = size - 1; i > 0; i--) {
            if (pengColors.get(i).equals(pengColors.get(i - 1))) {
                count++;
                pengColors.remove(i);
                pengColors.remove(i - 1);
                size -= 2;
                i = size;
            }
        }


        if (pengColors.size() > 1) {
            count += Math.ceil((pengColors.size() - 2) / 2.0);
        }
        return count;
    }
}
