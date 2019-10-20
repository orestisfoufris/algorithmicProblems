package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        Map<Character, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            List<Integer> list = map.computeIfAbsent(c, key -> new ArrayList<>());

            if (list.isEmpty()) {
                list.add(i);
                list.add(i);
            } else {
                int min = list.get(0);
                int max = list.get(1);
                list = new ArrayList<>();
                list.add(Math.min(min, i));
                list.add(Math.max(max, i));
                map.put(c, list);
            }
        }

        int k = -1;
        for (int i = 0; i < S.length(); ++i) {
            if (i <= k) continue;
            char c = S.charAt(i);
            List<Integer> indexes = map.get(c);
            k = indexes.get(1);
            int min = indexes.get(0);

            int t1 = indexes.get(0);
            int t2 = indexes.get(1);

            for (Map.Entry<Character, List<Integer>> entry: map.entrySet()) {
                List<Integer> val = entry.getValue();

                if (val.get(0) > t1 && val.get(0) < k) {
                    t2 = Math.max(t2, val.get(1));
                    k = Math.max(k, t2);
                }
            }
            res.add(k - min + 1);
        }

        return res;
    }
}
