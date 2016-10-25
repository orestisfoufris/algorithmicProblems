package EoPI.dynamicprogramming;

import java.util.Arrays;

/**
 * 17.12
 * @author Orestis 25/10/2016.
 */
public class LongestNonDecreasingSubsequence {

    static int findLIS(int[] array) {
        int N = array.length;
        if (N == 0) {
            return 0;
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (array[i] > array[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return max;
    }
}
