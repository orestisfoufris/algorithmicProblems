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


    public int minMutationAlternativeSolution(String start, String end, String[] bank) {
        if (start.length() != end.length()) return -1;

        Set<String> seen = new HashSet<>();
        List<Character> validChars = Arrays.asList('A', 'C', 'G', 'T');
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);

        Deque<String> d = new ArrayDeque<>();
        d.offer(start);
        seen.add(start);
        int level = 0;

        while (!d.isEmpty()) {
            int size = d.size();
            while(size-- > 0) {
                String s = d.pop();
                if (s.equals(end)) {
                    return level;
                }

                char[] current = s.toCharArray();
                for (int i = 0; i < current.length; ++i) {
                    char temp = current[i];

                    for (char c : validChars) {
                        current[i] = c;
                        String mutated = new String(current);

                        if (exists(mutated, bankSet) && !seen.contains(mutated)) {
                            d.offer(mutated);
                            seen.add(mutated);
                        }
                    }
                    current[i] = temp;
                }
            }
            level++;
        }

        return -1;

    }

    private boolean exists(String mutation, Set<String> validMutations) {
        return validMutations.contains(mutation);
    }

}
