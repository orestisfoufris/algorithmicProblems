package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 */
public class StringWithoutAaaOrBbb {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        int as = 0;
        int bs = 0;

        int ta = A;
        int tb = B;

        for (int i = 0; i < A + B; ++i) {
            if ((ta > 0 && as < 2 && ta >= tb) || bs >= 2) {
                sb.append("a");
                as++;
                ta--;
                bs = 0;
            } else {
                sb.append("b");
                bs++;
                tb--;
                as = 0;
            }
        }

        return sb.toString();
    }

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();

        for (int i = A.length - 1; i > 0; --i) {
            int max = i + 1;
            for (int k = 0; k < A.length; ++k) {
                if (A[k] == max) {
                    result.add(k + 1);
                    reverse(k, A);

                    if (max > 2) {
                        result.add(k + 2);
                        reverse(k + 1, A);
                    }

                    break;
                }
            }
        }

        return result;
    }

    public static void reverse(int k, int[] A) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
