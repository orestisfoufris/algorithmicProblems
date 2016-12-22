package com.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-primes/
 * 22/12/2016.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        return (int) Arrays
                .stream(findPrimesUpToN(n - 1))
                .filter(value -> value)
                .count();
    }

    private Boolean[] findPrimesUpToN(int n) {
        Boolean[] primes = new Boolean[n + 1];
        Arrays.fill(primes, true); // all are primes
        primes[0] = primes[1] = false;

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}
