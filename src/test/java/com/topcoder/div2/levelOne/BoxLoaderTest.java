package com.topcoder.div2.levelOne;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sweetleaf on 17/09/2014.
 * http://community.topcoder.com/stat?c=problem_statement&pm=2403&rd=4780&rm=150835&cr=8472634 *
 */

 public class BoxLoaderTest {
    private BoxLoader boxLoader = new BoxLoader();

    @Test
     public void boxLoaderPositive1(){
        int expected = 7560;
        int actual = boxLoader.mostItems(100, 98, 81, 3, 5, 7);

        assertEquals(actual, expected);
    }

    @Test
    public void boxLoaderPositive2(){
        int expected = 0;
        int actual = boxLoader.mostItems(10, 10, 10, 9, 9, 11);

        assertEquals(actual, expected);
    }

    @Test
    public void boxLoaderPositive3(){
        int expected = 100;
        int actual = boxLoader.mostItems(201,101,301,100,30,20);

        assertEquals(actual, expected);
    }

    @Test
    public void boxLoaderPositive4(){
        int expected = 833;
        int actual = boxLoader.mostItems(913, 687, 783, 109, 93, 53);

        assertEquals(actual, expected);
    }

    @Test
    public void boxLoaderPositive5(){
        int expected = 13984;
        int actual = boxLoader.mostItems(115, 113, 114, 5, 7, 3);

        assertEquals(actual, expected);
    }
}
