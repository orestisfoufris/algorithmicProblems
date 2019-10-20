package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 22/12/2016.
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();

        for (int i = len / 2; i >= 1; --i) {
            if (len % i == 0) {
                int middle = len / i;
                String substring = str.substring(0, i);

                int j;
                for(j = 1; j < middle; ++j) {
                    if(!substring.equals(str.substring(j * i,i + j * i))) {
                        break;
                    }
                }

                if(j == middle)
                    return true;
            }
        }

        return false;
    }


    public boolean repeatedSubstringPattern2(String str) {
        if (str == null || str.length() <= 1) {
            return false;
        }

        String su = str + str;

        su = su.substring(1, su.length() - 1);

        return su.contains(str);
    }
}
