package com.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 31/12/2016.
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Queue<Entry> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.counter == b.counter) {
                return 0;
            } else if (a.counter > b.counter) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i = 0; i < nums.length; ++i) {
            int value = map.computeIfAbsent(nums[i], key -> 0);
            map.put(nums[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Entry(entry.getKey(), entry.getValue()));
        }

        int counter = 0;
        while (!priorityQueue.isEmpty() && counter < k) {
            int value = priorityQueue.poll().value;
            result.add(value);
            counter++;
        }

        return result;
    }

    private static class Entry {
        private int value;
        private int counter;

        Entry(int value, int counter) {
            this.value = value;
            this.counter = counter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return value == entry.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

}
