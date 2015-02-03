package com.topcoder.algorithms.sorting;

import algorithms.sorting.QuickSort;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 02/02/2015
 */
public class QuickSortTest {

    @Test
    public void testQuickSort1(){
        List<Integer> sorted = newArrayList(3,3,5,6,7,8,9,9,10);
        List<Integer> given = newArrayList(8,3,3,6,10,9,9,5,7);
        QuickSort.sort(given);
        assertEquals(given, sorted);
    }

    @Test
    public void testQuickSort2(){
        List<String> sorted = newArrayList("a","b","c","d","d","e","f","g","h");
        List<String> given = newArrayList("h","c","d","b","a","e","g","f","d");
        QuickSort.sort(given);
        System.out.println(given);
        assertEquals(given, sorted);
    }

    @Test
    public void testQuickSort3(){
        List<Integer> sorted = newArrayList(1,4,5,6,8,9,32,88);
        List<Integer> given = newArrayList(4,88,32,1,5,6,8,9);
        QuickSort.sort(given);
        assertEquals(given, sorted);
    }
}
