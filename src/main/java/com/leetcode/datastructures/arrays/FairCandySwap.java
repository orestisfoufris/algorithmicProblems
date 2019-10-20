package com.leetcode.datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];

        int a = 0;
        int b = 0;
        for (int n: A) {
            a += n;
        }

        for (int n: B) {
            b += n;
        }

        outer:
        for (int i1 : A) {
            for (int i : B) {
                if (i1 == i) {
                    continue;
                }

                if (((a - i1) + i) == ((b - i) + i1)) {
                    result[0] = i1;
                    result[1] = i;
                    break outer;
                }
            }
        }

        return result;
    }


    public int findPairs(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int c = 0;

        for (int num1 : nums) {
            seen.add(Math.abs(num1) + k);
        }

        Set<Integer> all = new HashSet<>();
        for (int num : nums) {
            all.add(num);
        }

        for (int i: seen) {
            if (all.contains(i)) {
                c++;
            }
        }
        return c;
    }
}
