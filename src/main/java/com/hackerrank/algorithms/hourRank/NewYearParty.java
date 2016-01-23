package com.hackerrank.algorithms.hourRank;

import java.util.Scanner;

/**
 * @author Orestis
 * HourRank 4 Easy
 */
public class NewYearParty {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t[] = new int[n];
        for(int i=0; i < n; i++){
            t[i] = in.nextInt();
        }
        int  count = t[0];
        int prev = t[0];
        for (int i = 1; i < t.length; i++) {
            if (t[i] == prev) {
                count++;
            } else if (t[i] > count) {
                count = t[i];
            } else {
                count++;
            }
            prev = t[i];
        }

        System.out.println(count);
    }

}
