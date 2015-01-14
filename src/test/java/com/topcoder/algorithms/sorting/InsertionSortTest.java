package com.topcoder.algorithms.sorting;

import algorithms.sorting.InsertionSort;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 14/01/2015
 */
public class InsertionSortTest {

    @Test
    public void sort1(){
        int[] given = {5,4,8,9,10,66,22,5};
        int[] expected = {4,5,5,8,9,10,22,66};
        InsertionSort.sortArray(given);
        assertEquals(Arrays.toString(expected), Arrays.toString(given));
    }

    @Test
    public void sort2(){
        int[] given = {9,9,9,9,9,9,9,9,9};
        int[] expected = {9,9,9,9,9,9,9,9,9};
        InsertionSort.sortArray(given);
        assertEquals(Arrays.toString(expected), (Arrays.toString(given)));
    }

    @Test
    public void sort3(){
        int[] given = {100,8,44,21,96,85,55,44,1};
        int[] expected = {1,8,21,44,44,55,85,96,100};
        InsertionSort.sortArray(given);
        assertEquals(Arrays.toString(expected), (Arrays.toString(given)));
    }
}
