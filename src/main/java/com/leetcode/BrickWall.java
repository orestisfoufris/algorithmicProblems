package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/brick-wall/#/description
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(List<Integer> row : wall){
            int edges = 0;
            for (int j = 0; j < row.size() - 1; ++j) {
                edges += row.get(j);
                int count = map.getOrDefault(edges, 0) + 1;
                map.put(edges, count);
                max = Math.max(max, count);
            }
        }

        return wall.size() - max;
    }
}
