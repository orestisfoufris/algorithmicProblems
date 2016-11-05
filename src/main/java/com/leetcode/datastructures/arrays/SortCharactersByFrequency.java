package com.leetcode.datastructures.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 05/11/2016.
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char key = s.charAt(i);
            int value = map.computeIfAbsent(key, k -> 0);
            map.put(key, value + 1);
        }

        Map<Character, Integer> result = sortByValues(map);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            char c = entry.getKey();
            for (int i = 0; i < entry.getValue(); ++i) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = (k1, k2) -> {
            int compare = map.get(k2).compareTo(map.get(k1));
            if (compare == 0) {
                return 1;
            }

            else return compare;
        };

        Map<K, V> sortedByValues = new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

}
