package com.topcoder.div2.levelTwo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 27/09/2015
 */
public class IsItASquareTest {

    @Test
    public void test1() {
        int[] x = {0, 0, 2, 2};
        int[] y = {0, 2, 0, 2};

        assertEquals(IsItASquare.isSquare(x, y), "It's a square");
    }

    @Test
    public void test2() {
        int[] x = {0, 1, 5, 6};
        int[] y = {1, 6, 0, 5};

        assertEquals(IsItASquare.isSquare(x, y), "It's a square");
    }

    @Test
    public void test3() {
        int[] x = {0, 0, 7, 7};
        int[] y = {0, 3, 0, 3};

        assertEquals(IsItASquare.isSquare(x, y), "Not a square");
    }

    @Test
    public void test4() {
        int[] x = {0, 5000, 5000, 10000};
        int[] y = {5000, 0, 10000, 5000};

        assertEquals(IsItASquare.isSquare(x, y), "It's a square");
    }

    @Test
    public void test5() {
        int[] x = {1, 2, 3, 4};
        int[] y = {4, 3, 2, 1};

        assertEquals(IsItASquare.isSquare(x, y), "Not a square");
    }

    @Test
    public void test6() {
        int[] x = {0, 7, 7, 0};
        int[] y = {0, 3, 0, 3};

        assertEquals(IsItASquare.isSquare(x, y), "Not a square");
    }

    @Test
    public void test7() {
        int[] x = {3757, 150, 902, 2887};
        int[] y = {207, 7037, 4294, 4431};

        assertEquals(IsItASquare.isSquare(x, y), "Not a square");
    }

    @Test
    public void test8() {
        int[] x = {3931, 657, 1015, 3574};
        int[] y = {4194, 1634, 4551, 1277};

        assertEquals(IsItASquare.isSquare(x, y), "Not a square");
    }

    @Test
    public void test9() {
        int[] x = {3537, 3634, 3150, 4021};
        int[] y = {2783, 1912, 2299, 2396};

        assertEquals(IsItASquare.isSquare(x, y), "It's a square");
    }
}
