package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {

        if (digits.length == 0) return new int[]{1};

        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        List<Integer> list = new ArrayList<>();

        for (int digit : digits) {
            list.add(digit);
        }

        int i = digits.length - 1;
        boolean lastNine = list.get(0) == 9;

        while ( i >= 0) {
            if (list.get(i) == 9) {
                list.set(i, 0);
            } else {
                list.set(i, list.get(i) + 1);
                break;
            }

            --i;
        }

        if (lastNine && list.get(0) == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.addAll(list);
            list = l;
        }

        int[] arr = new int[list.size()];
        int k = 0;
        for (int integer : list) {
            arr[k++] = integer;
        }

        return arr;
    }
}
