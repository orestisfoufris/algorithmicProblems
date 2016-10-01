package EoPI.dynamicprogramming;

import java.util.Arrays;

/**
 * 17.2 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * Each operation is counted as 1 step. You can insert, delete or replace a character
 *
 * 01/10/2016
 */
public class ComputeTheLevenshteinDistance {

    public static int findMinimumEditDistance(String from, String to) {
        int m = from.length();
        int n = to.length();

        // edge cases
        if (n == 0 && m == 0) {
            return 0;
        } else if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // base case
        for (int i = 0; i < m; ++i) {
            dp[i][0] = i;
        }
        // base case
        for (int i = 0; i < n; ++i) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (from.charAt(i - 1) == to.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        assert (7 == findMinimumEditDistance("elephant", "hippo"));
        assert (7 == findMinimumEditDistance("aaapppp", ""));
        assert (1 == findMinimumEditDistance("frog", "fog"));
        assert (7 == findMinimumEditDistance("hippo", "elephant"));
        assert (8 == findMinimumEditDistance("hippo", "zzzzzzzz"));
        assert (1 == findMinimumEditDistance("hello", "hallo"));
    }
}
