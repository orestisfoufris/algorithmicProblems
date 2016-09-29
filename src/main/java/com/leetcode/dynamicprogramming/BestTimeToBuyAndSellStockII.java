package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 29/09/2016
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[] dp = new int[prices.length + 1];
        dp[0] = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp[i] += (prices[i] - min < 0) ? dp[i - 1] : dp[i - 1] + prices[i] - min;
            min = prices[i] - min > 0 ? prices[i] : Math.min(prices[i], min);
        }

        return dp[prices.length - 1];
    }

}
