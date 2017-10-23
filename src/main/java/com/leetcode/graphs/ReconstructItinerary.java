package com.leetcode.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Reconstruct Itinerary
 */
public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {

        List<String> result = new LinkedList<>();
        Map<String, Queue<String>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], key -> new PriorityQueue<>()).add(ticket[1]);
        }

        explore("JFK", graph, result);
        return result;
    }

    private void explore(String from, Map<String, Queue<String>> graph, List<String> result) {
        Queue<String> to = graph.get(from);

        while (to != null && !to.isEmpty()) {
            explore(to.poll(), graph, result);
        }

        result.add(0, from);
    }

}
