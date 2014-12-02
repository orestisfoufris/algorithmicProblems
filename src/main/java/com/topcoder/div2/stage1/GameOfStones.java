package com.topcoder.div2.stage1;

import java.util.Arrays;

/**
 * Created by Orestis on 23/10/2014
 * Problem statement - http://community.topcoder.com/stat?c=problem_statement&pm=13480&rd=16079
 */
public class GameOfStones {
    private int iterations = 0;
    public int count(int[] stones){
        int result = checkEquality(stones);
        return result;
    }

    private int checkEquality(int[] stones){
        int count = 0;
        int sum = 0;
        for(int k = 0; k< stones.length;k++){
            sum += stones[k];
        }
        if(stones.length > 0) {
            for (int i = 0; i < sum; i++) {
                Arrays.sort(stones);
                if(stones[stones.length-1] != 3) {
                    int j = 0;
                    while (j < stones.length - 1) {
                        if (stones[j] == stones[j + 1]) {
                            count++;
                        }
                        j++;
                    }
                    if (count == stones.length - 1) {
                        return iterations;
                    }
                    stones[0] = stones[0] + 2;
                    stones[stones.length - 1] = stones[stones.length - 1] - 2;
                    iterations++;
                    count = 0;
                }
            }
        }
        return -1;
    }
}
