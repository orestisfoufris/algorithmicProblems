package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/#/description
 */
public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        find(result, k, n, new ArrayList<>(), 0, 1);

        return result;
    }

    private static void find(List<List<Integer>> result, int k, int n, List<Integer> temp, int sum, int start) {
        if (temp.size() == k && sum == n) {
            result.add(new ArrayList<>(temp));
        }

        for (int j = start; j <= 9; ++j) {
            temp.add(j);
            if (sum + j <= n) {
                find(result, k, n, temp, sum + j, j + 1);
            }
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

}
