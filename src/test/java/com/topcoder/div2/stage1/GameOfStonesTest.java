package com.topcoder.div2.stage1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 23/10/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=13480&rd=16079
 */
public class GameOfStonesTest {
    private GameOfStones gameOfStones;

    @BeforeMethod
    public void setUp() {
        gameOfStones = new GameOfStones();
    }

    @Test
    public void test1() {
        int expected = 0;
        int[] given = {17};

        int actual = gameOfStones.count(given);

        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int expected = 3;
        int[] given ={7, 15, 9, 5};

        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

    @Test
    public void test3() {
        int expected = -1;
        int[] given ={2, 8, 4};

        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

    @Test
    public void test4() {
        int expected = -1;
        int[] given ={10, 15, 20, 12, 1, 20};

        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

    @Test
    public void test5(){
        int expected = 277;
        int[] given ={17, 1, 27, 29, 13, 1, 27, 3, 19, 3, 25, 1, 11, 9, 7, 17, 31, 25, 5, 11, 31, 9,
                15, 3, 3, 3, 11, 11, 1, 41, 5, 95, 7, 3, 41, 31, 7, 13, 15, 5, 17, 3, 9, 3, 11,
                27, 1, 23, 15, 5, 43, 11, 17, 7, 1, 3, 13, 69, 3, 43, 21, 1, 25, 1, 3, 11, 5, 43,
                13, 7, 15, 1, 1, 55, 37, 9, 5, 7, 21, 3, 23, 15, 1, 9, 3, 35, 13, 17, 7, 17, 27, 5,
                9, 19, 13, 1, 1, 1, 29};
        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

    @Test
     public void test6(){
        int expected = 539;
        int[] given ={1, 29, 11, 35, 57, 15, 85, 19, 5, 47, 53, 5, 63, 19, 13, 63, 27, 43, 53, 75, 67, 93, 33, 31, 47, 3,
                63, 17, 11, 53, 35, 23, 17, 45, 31, 19, 63, 75, 5, 3, 49, 19, 11, 89, 21, 69,
                71, 5, 45, 81, 31, 13, 11, 19, 7, 99, 33, 63, 19, 57, 73, 29, 35, 9, 47,
                1, 17, 7, 13, 31, 5, 85, 95, 23, 45, 65, 63, 41, 81, 33, 45, 1, 15,
                45, 19, 87, 51, 7, 13, 39, 1, 59, 29, 35, 1, 43};
        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

    @Test
    public void test7() {
        int expected = 0;
        int[] given ={100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100};
        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

    @Test
    public void test8() {
        int expected = 11;
        int[] given ={3, 5, 21, 31};
        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

    @Test
    public void test9() {
        int expected = 13;
        int[] given ={44, 6, 46};
        int actual = gameOfStones.count(given);
        assertEquals(actual, expected);
    }

}
