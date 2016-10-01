package EoPI.dynamicprogramming;

/**
 * Write a program that takes a final score and scores for individual plays
 * and returns the number of combinations of plays that result in the final score.
 *
 * 01/10/2016
 */
public class CountTheNumberOfScoreCombinations {

    public static int numOfCombinationForFinalScore(int finalScore, int[] scores) {
        int[] dp = new int[finalScore + 1];
        dp[0] = 1;

        for (int score : scores) {
            for (int i = score; i <= finalScore; ++i) {
                dp[i] += dp[i - score];
            }
        }

        return dp[finalScore];
    }


    public static void main(String[] args) {
        int[] scores = new int[] {2, 3, 7};
        assert(4 == numOfCombinationForFinalScore(12, scores));
        assert(1 == numOfCombinationForFinalScore(5, scores));
        assert(3 == numOfCombinationForFinalScore(9, scores));
    }
}
