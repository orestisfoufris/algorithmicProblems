package com.topcoder.div2.levelTwo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Orestis 14/10/2015.
 * problem statement : http://community.topcoder.com/stat?c=problem_statement&pm=12355&rd=15486
 */

public class PenguinPalsTest {

    @Test
    public void test1() {
        int expected = 4;
        int actual = PenguinPals.findMaximumMatching("RBRBRBRBR");

        assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        int expected = 5;
        int actual = PenguinPals.findMaximumMatching("RRRBRBRBRBRB");

        assertEquals(actual, expected);
    }

    @Test
    public void test3() {
        int expected = 3;
        int actual = PenguinPals.findMaximumMatching("RBRRBBRB");

        assertEquals(actual, expected);
    }

    @Test
    public void test4() {
        int expected = 25;
        int actual = PenguinPals.findMaximumMatching("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");

        assertEquals(actual, expected);
    }

    @Test
    public void test5() {
        int expected = 24;
        int actual = PenguinPals.findMaximumMatching("RBRBRBBBBBBBBRRBBRBBBBRBRBBBRRBBBRRRRBRRBRRBBRRRRR");

        assertEquals(actual, expected);
    }

    @Test
    public void test6() {
        int expected = 5;
        int actual = PenguinPals.findMaximumMatching("RRRRRRRRRR");

        assertEquals(actual, expected);
    }

    @Test
    public void test7() {
        int expected = 0;
        int actual = PenguinPals.findMaximumMatching("R");

        assertEquals(actual, expected);
    }
}
