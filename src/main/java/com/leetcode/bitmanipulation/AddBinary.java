package com.leetcode.bitmanipulation;

import java.util.Objects;

/**
 * https://leetcode.com/problems/add-binary/
 * 05/10/2016.
 */
public class AddBinary {

    // simulate binary addition
    public String addBinary(String a, String b) {
        if (Objects.equals(a, "")) {
            return b;
        } else if (Objects.equals(b, "")) {
            return a;
        }

        StringBuilder answer = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0) {
            int curIntA = i >-1 ? Character.getNumericValue(a.charAt(i)) : 0;
            int curIntB = j > -1 ? Character.getNumericValue(b.charAt(j)) : 0;
            answer.append((curIntA ^ curIntB ^ carry));
            carry = (curIntA + curIntB + carry) >= 2 ? 1 : 0;
            i--;
            j--;
        }

        return carry != 0 ? answer.append(carry).reverse().toString() : answer.reverse().toString();
    }

}
