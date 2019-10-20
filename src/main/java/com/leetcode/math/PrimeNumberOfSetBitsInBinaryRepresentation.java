package com.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        Set<Integer> primes = primes(20);

        for (int i = L; i <= R; ++i) {
            if (primes.contains(countBits(i))) {
                result++;
            }
        }

        return result;
    }

    private Set<Integer> primes(int n) {
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= n; ++i) {
            primes.add(i);
        }

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (primes.contains(i)) {
                for (int j = i * i; j <= n; j += i) {
                    primes.remove(j);
                }
            }
        }

        return primes;
    }

    private int countBits(int n) {
        return Integer.bitCount(n);
    }
}
