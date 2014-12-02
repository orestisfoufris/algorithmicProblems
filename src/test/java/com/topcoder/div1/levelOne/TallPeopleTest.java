package com.topcoder.div1.levelOne;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sweetleaf on 27/09/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=2923&rd=5854
 */
public class TallPeopleTest {
    private TallPeople tallPeople = new TallPeople();

    @Test
    public void testTallPeople1(){
        int[] expected = {4,7};
        String[] people = {"9 2 3", "4 8 7"};
        int[] actual = tallPeople.getPeople(people);

        assertEquals(actual, expected);
    }

    @Test
    public void testTallPeople2(){
        int[] expected = {4,4};
        String[] people = {"1 2","4 5","3 6"};
        int[] actual = tallPeople.getPeople(people);

        assertEquals(actual, expected);
    }
}
