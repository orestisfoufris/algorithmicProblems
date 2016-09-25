package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();

        backtrack(list, new ArrayList<>(), s, 0);

        return list;
    }

    private void backtrack(List<List<String>> list, List<String> prev, String s, int start){
        if (start == s.length()) {
            list.add(new ArrayList<>(prev));
        } else {
            for(int i = start; i < s.length(); i++) {
                if(isPalindrome(s, start, i)) {
                    prev.add(s.substring(start, i + 1));
                    backtrack(list, prev, s, i + 1);
                    prev.remove(prev.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

}
