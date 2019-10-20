package com.leetcode.datastructures.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Pair> fr = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            Pair val = fr.computeIfAbsent(nums[i], key -> new Pair(0, new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE}));
            val.times += 1;
            val.ind[0] = Math.min(val.ind[0], i);
            val.ind[1] = Math.max(val.ind[1], i);

            fr.put(nums[i], val);
        }

        Stream<Map.Entry<Integer, Pair>> stream =
                fr.entrySet().stream().sorted((a, b) -> -Integer.compare(a.getValue().times, b.getValue().times));

        AtomicInteger result = new AtomicInteger(Integer.MAX_VALUE);

        fr.entrySet().stream().max(Comparator.comparingInt(a -> a.getValue().times)).ifPresent((p) -> {
            int max = p.getValue().times;

            Stream<Map.Entry<Integer, Pair>> elems = stream.filter((e) -> max == e.getValue().times);
            elems.forEach((e) -> {
                Pair pair = e.getValue();
                result.set(Math.min(result.get(), pair.ind[1] - pair.ind[0]));
            });
        });

        return result.get() + 1;
    }

    private static class Pair {
        int times;
        int[] ind;

        private Pair(int times, int[] ind) {
            this.times = times;
            this.ind = ind;
        }
    }
}
