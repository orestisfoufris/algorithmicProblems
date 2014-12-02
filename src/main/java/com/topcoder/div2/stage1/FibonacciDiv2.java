package com.topcoder.div2.stage1;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Orestis on 02/12/2014
 * Problem statement: http://community.topcoder.com/stat?c=problem_statement&pm=13159
 */
public class FibonacciDiv2 {

    public int find(int N){
        List<Integer> fibs = fib(N);
        int last = (fibs.get(fibs.size() -1)) - N;
        int prev = N - (fibs.get(fibs.size() -2));

        if(last < prev){
            return last;
        }
        return prev;
    }

    private List<Integer> fib(int n){
        List<Integer> computedFibs = newArrayList(0,1);
        while(computedFibs.get(computedFibs.size() - 1) < n){
            computedFibs.add(computedFibs.get(computedFibs.size() - 1) + computedFibs.get(computedFibs.size() - 2));
        }
        return computedFibs;
    }
}
