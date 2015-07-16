package com.topcoder.div2.levelOne;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sweetleaf on 30/09/2014
 */
public class DoubleLetterTest {

    @Test
    public void test1() {
        DoubleLetter doubleLetter = new DoubleLetter();
        String actual = doubleLetter.ableToSolve("aabccb");
        assertEquals(actual,"Possible");
    }

    @Test
    public void test2() {
        DoubleLetter doubleLetter = new DoubleLetter();
        String actual = doubleLetter.ableToSolve("vutdtmvvihlmtdrecvhtlrceiwzhtuwthz");
        assertEquals(actual,"Impossible");
    }

    @Test
    public void test3() {
        DoubleLetter doubleLetter = new DoubleLetter();
        String actual = doubleLetter.ableToSolve("jgjollllojgjgesoofnqbdmfbbfmdxcrpprcxbqnfooseg");
        assertEquals(actual,"Possible");
    }

    @Test
    public void test4() {
        DoubleLetter doubleLetter = new DoubleLetter();
        String actual = doubleLetter.ableToSolve("pyvpnfpmnyfrpzppbyerqvfxfxmzybnqeddn");
        assertEquals(actual,"Impossible");
    }
}
