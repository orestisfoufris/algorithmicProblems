package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/
 * 16/10/2016.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] array) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] i : array) {
            int x = i[0]; int y = i[1];
            graph.get(x).add(y);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int index) {
        if (visited[index] == -1) {
            return false;
        }

        if (visited[index] == 1) {
            return true;
        }

        visited[index] = -1; // visited
        for (int course : graph.get(index)) {
            if (!dfs(graph, visited, course)) {
                return false;
            }
        }

        visited[index] = 1; // no cycle for this vertex
        return true;
    }

}
