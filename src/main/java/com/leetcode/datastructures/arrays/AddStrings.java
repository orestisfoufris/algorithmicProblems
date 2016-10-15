package com.leetcode.datastructures.arrays;

/**
 * https://leetcode.com/problems/add-strings/
 * 5/10/2016.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int curry = 0;
        int one = num1.length();
        int two = num2.length();

        if (one == 0 && two == 0) { return ""; }
        if (one == 0 ||two == 0) {
            return one == 0 ? num2 : num1;
        }

        if (one != two) {
            if (one > two) {
                StringBuilder num2rev = new StringBuilder(num2).reverse();
                for (int i = 0; i < one - two; ++i) {
                    num2rev.append("0");
                }

                num2 = num2rev.reverse().toString();
            } else {
                StringBuilder num1rev = new StringBuilder(num1).reverse();
                for (int i = 0; i < two - one; ++i) {
                    num1rev.append("0");
                }

                num1 = num1rev.reverse().toString();
            }
        }

        one = num1.length();
        two = num2.length();

        for (int i = one - 1; i >= 0; --i) {
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(i) - '0';

            int add = c1 + c2 + curry;

            if (add > 9) {
                curry = 1;
                sb.append(add % 10);
            } else {
                curry = 0;
                sb.append(add);
            }
        }

        if (curry == 1) sb.append(1);

        return sb.reverse().toString();
    }
}
