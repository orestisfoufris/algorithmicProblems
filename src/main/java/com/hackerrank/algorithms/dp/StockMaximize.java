package com.hackerrank.algorithms.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *  @author Orestis
 *  https://www.hackerrank.com/challenges/stockmax
 */
public class StockMaximize {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(in.readLine());
        for (int k = 0; k < T; ++k) {
            int N = Integer.valueOf(in.readLine());
            String[] stockPrices = in.readLine().split(" ");


            int maxPrice = 0;
            long profit = 0;
            for (int j = N - 1; j >= 0; --j) {
                maxPrice = Math.max(maxPrice, Integer.valueOf(stockPrices[j]));
                profit += Math.abs(maxPrice - Integer.valueOf(stockPrices[j]));
            }

            out.write(String.valueOf(profit) + "\n");
        }

        out.close();
    }
}
