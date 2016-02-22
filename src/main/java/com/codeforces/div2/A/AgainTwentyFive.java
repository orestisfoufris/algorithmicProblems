package com.codeforces.div2.A;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Orestis
 * http://codeforces.com/problemset/problem/630/A
 */

public class AgainTwentyFive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger exponent = sc.nextBigInteger();
        BigInteger p = new BigInteger("5");
        BigInteger mod = new BigInteger("100");

        BigInteger result = p.modPow(exponent, mod);

        System.out.println(result);
    }

}