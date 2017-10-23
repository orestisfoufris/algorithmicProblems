package com.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/kill-process/#/description
 */
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int i = 0; i < ppid.size(); ++i) {
            List<Integer> nodes = g.computeIfAbsent(ppid.get(i), key -> new ArrayList<>());
            nodes.add(pid.get(i));
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        Deque<Integer> d = new ArrayDeque<>();
        d.offer(kill);

        while(!d.isEmpty()) {
            int next = d.pop();
            result.add(next);

            List<Integer> vertices = g.get(next);
            if (vertices != null) {
                for (int p : g.get(next)) {
                    if (!seen.contains(p)) {
                        seen.add(p);
                        d.offer(p);
                    }
                }
            }
        }

        return result;
    }

}
