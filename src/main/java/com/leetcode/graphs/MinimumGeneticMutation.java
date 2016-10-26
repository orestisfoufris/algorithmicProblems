package com.leetcode.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 * 26/10/2016.
 */
public class MinimumGeneticMutation {

    public static int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        boolean found = false;
        for (String b : bank) {
            if (b.equals(end)) {
                found = true;
            }
        }

        if (!found) {
            return -1;
        }

        Deque<Pair> deque = new ArrayDeque<>();
        deque.offer(new Pair(start, 1));

        while(!deque.isEmpty()) {
            Pair pair = deque.poll();

            for (String b : bank) {
                if (findDistance(pair.value, b) == 1) {
                    if (b.equals(end)) {
                        return pair.difference;
                    } else {
                        Pair newPair = new Pair(b, pair.difference + 1);
                        deque.offer(newPair);

                    }
                }
            }
        }


        return -1;
    }

    private static int findDistance(String a, String b) {
        if (a.equals(b)) { return 0; }
        if (a.length() != b.length()) { return -1; }

        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff;
    }

    private static class Pair {
        String value;
        int difference;
        boolean visited = false;

        Pair(String value, int difference) {
            this.value = value;
            this.difference = difference;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return difference == pair.difference &&
                    visited == pair.visited &&
                    Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, difference, visited);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value='" + value + '\'' +
                    ", difference=" + difference +
                    ", visited=" + visited +
                    '}';
        }
    }

}
