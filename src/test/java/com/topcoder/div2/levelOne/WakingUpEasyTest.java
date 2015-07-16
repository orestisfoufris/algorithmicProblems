package com.topcoder.div2.levelOne;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 15/10/2014
 */
public class WakingUpEasyTest {

    WakingUpEasy wakingUpEasy = new WakingUpEasy();

    @Test
    public void test1() {
        int[] array = {5, 2, 4};
        int sleep =13;
        int actual = wakingUpEasy.countAlarms(array, sleep);
        assertEquals(actual, 4);
    }

    @Test
    public void test2() {
        int[] array = {42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37,
                92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36,
                95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69};
        int sleep =9999;
        int actual = wakingUpEasy.countAlarms(array, sleep);
        assertEquals(actual,203);
    }

    @Test
    public void test3() {
        int[] array = {5, 2, 4};
        int sleep =3;
        int actual = wakingUpEasy.countAlarms(array, sleep);
        assertEquals(actual, 1);
    }

    @Test
    public void test4() {
        int[] array = {1};
        int sleep =10000;
        int actual = wakingUpEasy.countAlarms(array, sleep);
        assertEquals(actual,10000);
    }

    @Test
    public void test5() {
        int[] array = {7, 1, 52, 48, 31, 3, 31, 32, 55, 20, 52, 36, 30, 30, 21, 47,
                31, 44, 5, 55, 8, 32, 52, 19, 8, 2, 48, 14, 11, 30, 31, 55, 9, 17, 37,
                53, 40, 22, 53, 55, 9, 11, 4};
        int sleep =1245;
        int actual = wakingUpEasy.countAlarms(array, sleep);
        assertEquals(actual,42);
    }
}
