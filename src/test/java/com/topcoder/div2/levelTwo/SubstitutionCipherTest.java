package com.topcoder.div2.levelTwo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Orestis
 */
public class SubstitutionCipherTest {

    @Test
    public void test1() {
        String result = SubstitutionCipher.decode("THEQUICKBROWNFOXJUMPSOVERTHELAZYHOG",
                "UIFRVJDLCSPXOGPYKVNQTPWFSUIFMBAZIPH", "DIDYOUNOTICESKIPPEDLETTER");

        assertEquals(result, "CHCXNTMNSHBDRJHOODCKDSSDQ");
    }

    @Test
    public void test2() {
        String result = SubstitutionCipher.decode("BANANA",
                "METETE", "TEMP");

        assertEquals(result, "");
    }

    @Test
    public void test3() {
        String result = SubstitutionCipher.decode("ABCDEFGHIJKLMNOPQRSTUVWXY",
                "ABCDEFGHIJKLMNOPQRSTUVWXY", "ZZZZZZZZZZZZZZZ");

        assertEquals(result, "ZZZZZZZZZZZZZZZ");
    }
}
