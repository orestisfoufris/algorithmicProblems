package com.topcoder.algorithms.sorting;

import algorithms.sorting.MergeSort;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 17/01/2015
 */
public class MergeSortTest {
    @Test
    public void sort1(){
        List<Integer> given = newArrayList(5,4,3,2,1,0,1);
        List<Integer> expected = newArrayList(0,1,1,2,3,4,5);
        MergeSort.sort(given);
        assertEquals(given, expected);
    }

    @Test
    public void sort2(){
        List<Integer> given = newArrayList(8,7,6,5,4);
        List<Integer> expected = newArrayList(4,5,6,7,8);
        MergeSort.sort(given);
        assertEquals(given, expected);
    }

    @Test
    public void sort3(){
        List<Integer> given = newArrayList(100,8,44,21,96,85,55,44,1);
        List<Integer> expected = newArrayList(1,8,21,44,44,55,85,96,100);
        MergeSort.sort(given);
        assertEquals(given, expected);
    }

    @Test
    public void sort4(){
        List<Integer> given = newArrayList(10,9,8,7,6,5,4,3,2,1,0);
        List<Integer> expected = newArrayList(0,1,2,3,4,5,6,7,8,9,10);
        MergeSort.sort(given);
        assertEquals(given, expected);
    }

    @Test
     public void sort5(){
        List<Integer> given = newArrayList(8,3,6,9,1,0);
        List<Integer> expected = newArrayList(0,1,3,6,8,9);
        MergeSort.sort(given);
        assertEquals(given, expected);
    }

    @Test
    public void sort6(){
        List<String> given = newArrayList("f","e","d","c","b","a");
        List<String> expected = newArrayList("a","b","c","d","e","f");
        MergeSort.sort(given);
        assertEquals(given, expected);
    }
}
