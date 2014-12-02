package com.topcoder.div2.stage1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sweetleaf on 16/09/2014
 */

public class BettingMoneyTest {

    private BettingMoney bettingMoney = new BettingMoney();

    @Test
    public void moneyMadePositive1(){
        int[] amounts = {10,20,30};
        int[] centsPerDollar = {20,30,40};
        int finalResult = 1;

        int expected = 3400;
        int actual = bettingMoney.moneyMade(amounts, centsPerDollar, finalResult);

        assertEquals(actual, expected);
    }

    @Test
    public void moneyMadePositive2(){
        int[] amounts = {200,300,100};
        int[] centsPerDollar = {10,10,10};
        int finalResult = 2;

        int expected = 49000;
        int actual = bettingMoney.moneyMade(amounts, centsPerDollar, finalResult);

        assertEquals(actual, expected);
    }

    @Test
    public void moneyMadePositive3(){
        int[] amounts = {100};
        int[] centsPerDollar = {10};
        int finalResult = 0;

        int expected = -1000;
        int actual = bettingMoney.moneyMade(amounts, centsPerDollar, finalResult);

        assertEquals(actual, expected);
    }

    @Test
    public void moneyMadePositive4(){
        int[] amounts = {5000, 5000};
        int[] centsPerDollar = {100,2};
        int finalResult = 0;

        int expected = 0;
        int actual = bettingMoney.moneyMade(amounts, centsPerDollar, finalResult);

        assertEquals(actual, expected);
    }

    @Test
    public void moneyMadePositive5(){
        int[] amounts = {1249, 1495, 1060, 2165, 2147, 872, 1033, 3364, 613, 3030, 3306, 1267, 2973, 1997, 2183, 1820, 3308, 2167, 1471, 3005, 2265, 4612, 3592, 2485, 1189, 993,
                4185, 2681, 1642, 1978, 2735, 1211, 1514, 572, 4450, 4231, 1306, 1161, 748, 4222, 2585, 2450, 2764, 3697, 3849, 571, 2732, 4828, 2400, 1856};
        int[] centsPerDollar = {2055, 654, 3243, 3537, 3040, 3274, 2424, 4773, 1207, 3325, 1110, 3448, 466, 3846, 3118, 1708, 16, 2260, 1607, 1452, 778, 834, 2925, 4370, 470, 4445,
                2112, 4850, 4245, 3194, 1432, 1506, 2034, 4910, 3384, 1608, 288, 4811, 4014, 2088, 2403, 113, 1176, 1814, 3267, 2205, 2033, 1434, 859, 1706};
        int finalResult = 49;

        int expected = 8250964;
        int actual = bettingMoney.moneyMade(amounts, centsPerDollar, finalResult);

        assertEquals(actual, expected);
    }
}
