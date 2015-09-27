package com.topcoder.div2.levelTwo;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Created by Orestis on 27/09/2015
 * Problem statement: http://community.topcoder.com/stat?c=problem_statement&pm=14004&rd=16548
 */
public final class IsItASquare {

    public static String isSquare(int[] x, int[] y) {
        Set<Double> result = newHashSet();

        for (int i = 0; i < x.length - 2; i++) {
            for (int j = i; j < x.length - 1; j++) {
                result.add(findDistance(x[i], x[j + 1], y[i], y[j + 1]));
            }
        }

        if (result.size() > 2) {
            return "Not a square";
        }

        return "It's a square";
    }

    /**
     * find the distance between two points in a cartesian system
     */
    private static double findDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
