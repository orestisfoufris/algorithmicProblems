package com.topcoder.div2.levelThree;

import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

/**
 * Created by Orestis on 09/07/2015
 * topcoder problem statement: http://community.topcoder.com/stat?c=problem_statement&pm=13349
 */
public class JanuszInTheCasino {
    private final Map<Set<Long>, Double> results = newHashMap();

    /**
     * @param n number of players
     * @param m fields
     * @param k rounds
     * @return double probabilities
     */
    public double findProbability(long n, int m, int k) {
        double result;

        Set<Long> vals = newHashSet(n, (long)k << 1);
        if (results.containsKey(vals)) {
            return results.get(vals);
        } else {
            if (k == 0) {
                if (n >= 1) {
                    result = 1.0;
                } else {
                    result = 0.0;
                }
            } else {
                double p = ((double) n % m) / m;
                result = (p * findProbability((n - (n / m + 1)), m, k - 1)) +
                        ((1 - p) * findProbability((n - (n / m)), m, k - 1));
            }
        }
        results.put(vals, result);
        return result;
    }
}