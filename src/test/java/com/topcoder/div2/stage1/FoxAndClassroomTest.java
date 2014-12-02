package com.topcoder.div2.stage1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 20/10/2014
 */
public class FoxAndClassroomTest {
    private FoxAndClassroom fox  = new FoxAndClassroom();

    @Test
    public void test1(){
        String expected = "Possible";
        String actual = fox.ableTo(2, 3);

        assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        String expected = "Impossible";
        String actual = fox.ableTo(10, 10);

        assertEquals(actual, expected);
    }
}
