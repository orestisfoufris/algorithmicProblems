package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int counter = s.length();
        int si = 0;

        if (s.length() == 0) {
            return true;
        }

        for (int i = 0; i < t.length(); ++i) {
            if (s.charAt(si) == t.charAt(i)) {
                counter--;
                si++;

                if (counter < 0) {
                    return false;
                }

                if (si == s.length()) {
                    break;
                }
            }
        }

        return counter == 0;
    }

    // obviously that gives TLE for large t
    public boolean isSubsequenceBacktracking(String s, String t) {
        boolean res = backtrack(0, s, t, "", false);
        return s.length() == 0 || res;
    }

    private boolean backtrack(int start, String s, String t, String previous, boolean found) {
        if (found) {
            return true;
        }

        if (previous.length() > s.length()) {
            return false;
        }

        for (int i = start; i < t.length(); ++i) {
            previous = previous + t.charAt(i);

            if (previous.equals(s)) {
                return true;
            }

            found |= backtrack(i + 1, s, t, previous, found);
            previous = previous.substring(0, previous.length() - 1);
        }

        return found;
    }

}
