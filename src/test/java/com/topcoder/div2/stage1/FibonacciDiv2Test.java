package com.topcoder.div2.stage1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 02/12/2014
 */
public class FibonacciDiv2Test {
    private FibonacciDiv2 fib;

    @BeforeMethod
    public void setup(){
        fib = new FibonacciDiv2();
    }

    @Test
    public void testFib1() {
        int expected = 2;
        int actual = fib.find(19);

        assertEquals(actual, expected);
    }

    @Test
    public void testFib2() {
        int expected = 0;
        int actual = fib.find(13);

        assertEquals(actual, expected);
    }

    @Test
    public void testFib3() { // biggest input
        int expected = 167960;
        int actual = fib.find(1000000);

        assertEquals(actual, expected);
    }
}
