package com.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/number-complement/#/description
 */
public class FindComplement {

    public static int findComplement(int num) {
        int mask = 1;
        int last = 0;

        for (int i = 0; i < 31; i++) {
            if ((mask & num) == 1) {
                last = i;
            }
            mask <<= 1;
        }

        int temp = 0;
        mask = 1;
        for (int i = 0; i <= last; ++i) {
            temp = temp | mask;
            mask = mask << 1;
        }

        return temp ^ num;
    }

}
