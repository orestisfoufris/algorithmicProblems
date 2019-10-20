package com.projectEuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Largest prime factor
 */
public class ProjectEuler3 {

    private static final List<Integer> primes = f(100000);

    public static void solve(long n, List<Integer> primes) {
        for (int i = primes.size() - 1; i >= 0; --i) {

            if (n % primes.get(i) == 0) {
                System.out.println(primes.get(i));
                break;
            }
        }
    }

    private static List<Integer> f(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // all are primes
        primes[0] = primes[1] = false;

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (primes[i]) {
                result.add(i);
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        solve(17, primes);
    }
}
