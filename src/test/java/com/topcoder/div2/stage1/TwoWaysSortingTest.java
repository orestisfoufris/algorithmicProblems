package com.topcoder.div2.stage1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 19/10/2014
 */
public class TwoWaysSortingTest {
    private TwoWaysSorting sorting = new TwoWaysSorting();

    @Test
    public void test1() {
        String expected = "both";
        String[] array = {"a", "aa", "bbb"};
        String actual = sorting.sortingMethod(array);

        assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        String expected = "lengths";
        String[] array ={"c", "bb", "aaa"};
        String actual = sorting.sortingMethod(array);

        assertEquals(actual, expected);
    }

    @Test
    public void test3() {
        String expected = "none";
        String[] array ={"etdfgfh", "aio"};
        String actual = sorting.sortingMethod(array);

        assertEquals(actual, expected);
    }

    @Test
     public void test4() {
        String expected = "lexicographically";
        String[] array = {"aaa", "z"};
        String actual = sorting.sortingMethod(array);

        assertEquals(actual, expected);
    }

    @Test
    public void test5() {
        String expected = "both";
        String[] array = {"z"};
        String actual = sorting.sortingMethod(array);

        assertEquals(actual, expected);
    }
}
