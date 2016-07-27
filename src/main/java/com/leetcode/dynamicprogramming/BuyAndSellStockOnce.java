package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuyAndSellStockOnce {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int[] profit = new int[prices.length];

        int min = prices[0];

        for(int i = 1; i < prices.length; ++i) {
            if (prices[i] < min)  {
                min = prices[i];
            }

            profit[i] = Math.max(profit[i - 1], prices[i] - min);

        }

        return profit[prices.length - 1];

    }

}
