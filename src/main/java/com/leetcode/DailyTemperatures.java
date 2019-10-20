package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/daily-temperatures/submissions/
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {
        if (T.length < 1) return new int[] {0};

        Map<Integer, Pair> map = new HashMap<>();
        map.put(T[T.length - 1], new Pair(T.length - 1, 0));

        int[] res = new int[T.length];

        for (int i = T.length - 2; i >= 0; --i) {
            if (T[i] < T[i + 1]) {
                res[i] = 1;
                map.put(T[i], new Pair(i + 1, T[i + 1]));
            } else {
                res[i] = solve(i, map, T);
            }
        }

        return res;
    }

    private static int solve(int curIndex, Map<Integer, Pair> map, int[] T) {
        Pair prev = map.get(T[curIndex + 1]);

        if (prev.solutionValue == 0) {
            map.put(T[curIndex], new Pair(T.length - 1, 0));
            return 0;
        }

        Pair prevRes = prev;

        while (prevRes.solutionValue <= T[curIndex]) {
            prevRes = map.get(T[prevRes.solutionIndex]);

            if (prevRes.solutionValue == 0) {
                map.put(T[curIndex], new Pair(T.length - 1, 0));
                return 0;
            }
        }

        map.put(T[curIndex], prevRes);
        return prevRes.solutionIndex - curIndex;
    }

    private static class Pair {
        int solutionIndex;
        int solutionValue;

        Pair(int index, int gt) {
            this.solutionIndex = index;
            this.solutionValue = gt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return solutionIndex == pair.solutionIndex &&
                    solutionValue == pair.solutionValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(solutionIndex, solutionValue);
        }
    }
}
