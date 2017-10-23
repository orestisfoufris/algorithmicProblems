package com.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {
        Map<Pair, Integer> map = new HashMap<>();
        return findways(nums, S, 0, 0, map);
    }

    private static int findways(int nums[], int S, int i, int sum, Map<Pair, Integer> map) {
        if (i >= nums.length) {
            if (sum == S) {
                return 1;
            }

            return 0;
        }

        Pair p = new Pair(i, sum);
        if (map.containsKey(p)) {
            return map.get(p);
        }

        int result = findways(nums, S, i + 1, sum - nums[i], map) +
                findways(nums, S, i + 1, sum + nums[i], map);

        map.put(p, result);
        return result;
    }

    private static class Pair {
        private final int index;
        private final int sum;

        private Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index &&
                    sum == pair.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, sum);
        }
    }
}

