package com.topcoder.div2.levelThree;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Orestis on 09/07/2015
 */

public class JanuszInTheCasinoTest {
    private JanuszInTheCasino j;

    @BeforeMethod
    public void setup() {
        j = new JanuszInTheCasino();
    }

    @Test
    public void test_zero() {
        double expected = 1.0;
        double actual = j.findProbability(1000000000000L, 3, 50);

        assertTrue(Math.abs(actual - expected) <= 0.001);
    }

    @Test
    public void test_one() {
        double expected = 0.012293671817445784;
        double actual = j.findProbability(432545123543L, 2, 45);

        assertTrue(Math.abs(actual - expected) <= 0.001);
    }

    @Test
    public void test_two() {
        double expected = 1.0;
        double actual = j.findProbability(4, 3, 2);

        assertTrue(Math.abs(actual - expected) <= 0.001);
    }

    @Test
    public void test_three() {
        double expected = 0.75;
        double actual = j.findProbability(3, 2, 2);

        assertTrue(Math.abs(actual - expected) <= 0.001);
    }

    @Test
    public void test_four() {
        double expected = 0.9999999999999996;
        double actual = j.findProbability(786342534673L, 7, 48);

        assertTrue(Math.abs(actual - expected) <= 0.001);
    }

    @Test
    public void test_five() {
        double expected = 0.9999999999999987;
        double actual = j.findProbability(1000000000000L, 39, 40);

        assertTrue(Math.abs(actual - expected) <= 0.001);
    }

}
