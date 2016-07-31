package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if(n == 1 || n == 2) { return 1; }
        if(n == 3) { return 2; }
        if(n == 4) { return 4; }

        return 3 * (Math.max(n - 3, integerBreak(n - 3)));
    }
    
}
