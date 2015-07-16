package com.topcoder.div2.levelOne;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 29/03/2015
 */
public class SquareScoresDiv2Test {

    @Test
    public void test1() {
        int expected = 8;
        SquareScoresDiv2 s = new SquareScoresDiv2();
        int actual = s.getScore("aaaba");

        assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        int expected = 12;
        SquareScoresDiv2 s = new SquareScoresDiv2();
        int actual = s.getScore("zzzxxzz");

        assertEquals(actual, expected);
    }


    @Test
    public void test3() {
        int expected = 26;
        SquareScoresDiv2 s = new SquareScoresDiv2();
        int actual = s.getScore("abcdefghijklmnopqrstuvwxyz");

        assertEquals(actual, expected);
    }

    @Test
    public void test4() {
        int expected = 5050;
        SquareScoresDiv2 s = new SquareScoresDiv2();
        int actual = s.getScore("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        assertEquals(actual, expected);
    }

    @Test
    public void test5() {
        int expected = 1;
        SquareScoresDiv2 s = new SquareScoresDiv2();
        int actual = s.getScore("p");

        assertEquals(actual, expected);
    }
}
