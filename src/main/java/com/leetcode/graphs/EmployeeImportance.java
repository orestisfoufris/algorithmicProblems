package com.leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/employee-importance/description/
 */
public class EmployeeImportance {

    private Map<Integer, Employee> map = new HashMap<>();
    private int count = 0;

    public int getImportance(List<Employee> employees, int id) {
        for (Employee emp : employees) {
            map.putIfAbsent(emp.id, emp);
        }

        Set<Integer> seen = new HashSet<>();
        dfs(map.get(id), seen);

        return count;
    }

    private void dfs(Employee emp, Set<Integer> seen) {
        if (!seen.contains(emp.id)) {
            count += emp.importance;
            seen.add(emp.id);

            for (Integer id : emp.subordinates) {
                dfs(map.get(id), seen);
            }
        }
    }

    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        int id;
        // the importance value of this employee
        int importance;
        // the id of direct subordinates
        List<Integer> subordinates;
    }
}
