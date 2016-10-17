package com.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 17/10/2016.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] array) {

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        Deque<Integer> deque = new ArrayDeque<>();

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] i : array) {
            int x = i[0]; int y = i[1];
            graph.get(x).add(y);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(i, visited, deque, graph)) {
                return new int[] {};
            }
        }

        int[] result = new int[numCourses];
        int index = numCourses - 1;
        while (!deque.isEmpty()) {
            result[index--] = deque.pop();
        }

        return result;
    }

    private boolean dfs(int i, int[] visited, Deque<Integer> deque, List<List<Integer>> graph) {
        if (visited[i] == - 1) {
            return false;
        } else if (visited[i] == 1) {
            return true;
        }

        visited[i] = - 1; // mark visited
        for (int course : graph.get(i)) { // for each adjacent node
            if (!dfs(course, visited, deque, graph)) {
                return false;
            }
        }

        deque.push(i); // topological sort
        visited[i] = 1; // no cycles for this vertex

        return true;
    }

}
